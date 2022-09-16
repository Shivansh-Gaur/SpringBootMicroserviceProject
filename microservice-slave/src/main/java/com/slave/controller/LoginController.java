package com.slave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slave.dto.RegUser;
import com.slave.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService logservice;

	@GetMapping("/logins")
	public String loginuser() {
		System.out.println("hello");
		return "login";
	}

	@PostMapping("/logins")
	public String log(@RequestParam String username, @RequestParam String password, Model model) {
		System.out.println("hiiiii");
		RegUser reg1 = logservice.findByUsername(username);
		if (username.equalsIgnoreCase(reg1.getUsername()) && password.equalsIgnoreCase(reg1.getPassword())) {
			model.addAttribute("user", username);
			return "success";
		} else {
			model.addAttribute("error", "Invalid Credentials!!!");
			return "login";
		}

	}

	@GetMapping("/logins/{username}/{password}")
	@ResponseBody
	public String logs(@PathVariable("username") String username, @PathVariable("password") String password) {
	//	System.out.println("hiiiii Rest");
		RegUser reg1 = logservice.findByUsername(username);
	//	System.out.println(reg1.getUsername());
	//	System.out.println(reg1.getPassword());
//	return reg1;

		if (username.equalsIgnoreCase(reg1.getUsername()) && password.equalsIgnoreCase(reg1.getPassword())) {

			return "correct";
		} else {

			return "wrong";
		}

	}

	@GetMapping("/logouts")
	public String logout() {
		return "redirect:login";
	}

}
