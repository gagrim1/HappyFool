package com.DnD.HappyFool.Controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.DnD.HappyFool.Domain.Entity.Role;
import com.DnD.HappyFool.Domain.Entity.Status;
import com.DnD.HappyFool.Domain.Entity.User;
import com.DnD.HappyFool.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RegistrationController {
	
	private final UserRepository userRepo;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model) {
		User userFromDB = userRepo.findByUsername(user.getUsername());
		if(userFromDB != null) {
			model.put("message", "User exists!");
			return "registration";
		}
		user.setStatus(Status.ACTIVE);
		userRepo.save(user);
		
		return "redirect:/login";
	}

}
