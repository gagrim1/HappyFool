package com.DnD.HappyFool.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GreetingController {
    
	@GetMapping
	public String example(Model model) {
		model.addAttribute("defaultName", "Peter Parker");
		return "hello";
	}
}
