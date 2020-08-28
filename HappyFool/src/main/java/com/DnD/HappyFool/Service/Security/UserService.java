package com.DnD.HappyFool.Service.Security;

import org.springframework.stereotype.Service;

import com.DnD.HappyFool.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
	private final UserRepository userRepo;
	
}
