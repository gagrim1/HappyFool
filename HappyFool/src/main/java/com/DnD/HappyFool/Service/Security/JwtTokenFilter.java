package com.DnD.HappyFool.Service.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;


@Component
public class JwtTokenFilter extends GenericFilterBean {
	
    private final JwtTokenProvider jwtTokenProvider;
    
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    	this.jwtTokenProvider = jwtTokenProvider;
    }

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response, FilterChain chain) {
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		try {
	        if(token != null && jwtTokenProvider.validateToken(token)) {
		        Authentication authentication = jwtTokenProvider
		    	    	.getAuthentication(token);
		        if(authentication != null) {
			        SecurityContextHolder.getContext()
			        .setAuthentication(authentication);
		        }
	        }
	    }catch(JwtAuthenticationException e) {
	    	SecurityContextHolder.clearContext();
	    	try {
				((HttpServletResponse) response)
				.sendError(e.getHttpStatus().value());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	throw new JwtAuthenticationException(
	    			"JWT token is exprired or invalid");
	    }
		
		try {
			chain.doFilter(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}
