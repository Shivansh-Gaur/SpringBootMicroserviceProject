package com.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.master.dto.RegUser;
import com.master.service.RegisterService;
import com.master.service.UpdateService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class RegisterController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RegisterService regservice;

	@Autowired
	UpdateService updateservice;

	@GetMapping("/list")
	public String show() {
		return "list";
	}

	@GetMapping("/register")
	public String registeruser(Model model) {
		model.addAttribute("title", "Registration Page");
		return "register";
	}

	@PostMapping("/register")
	public String welcome(@ModelAttribute("reg") RegUser reg) {
		regservice.save(reg);
		return "welcome";
	}

	@GetMapping("/backmainmenu")
	public String mainmenu() {
		return "redirect:list";
	}

	@GetMapping("/logins")
	public String loginuser() {

		return "login";
	}

	@PostMapping("/logins")
	@HystrixCommand(fallbackMethod = "getfallback")
	public String log(@RequestParam String username, @RequestParam String password, Model model) {

		String result = restTemplate.getForObject("http://microservice-slave/logins/" + username + "/" + password,
				String.class, "username", "password");

		// System.out.println(result);
		/*
		 * if (username.equalsIgnoreCase(result.getUsername()) &&
		 * password.equalsIgnoreCase(result.getPassword())) { model.addAttribute("user",
		 * username); return "success"; } else { model.addAttribute("error",
		 * "Invalid Credentials!!!!"); return "login"; }
		 */

		if (result.equalsIgnoreCase("correct")) {
			model.addAttribute("user", username);
			return "success";
		} else {
			model.addAttribute("error", "Invalid credentials!!!!");
			return "login";
		}

	}

	public String getfallback( @RequestParam String username, @RequestParam String password, Model model ) {
		return "fallback";
	}

	@GetMapping("/logouts")
	public String logout() {
		return "list";
	}

	@GetMapping("/main")
	public String menu() {
		return "list";
	}

	@GetMapping("/showall")
	public String showallusers(Model model) {
		List<RegUser> show = (List<RegUser>) regservice.findAll();
		model.addAttribute("show", show);
		return "allusers";
	}

	@GetMapping("/delete/{id}")
	public String deluser(@PathVariable("id") Integer id) {
		if (regservice.existsById(id)) {
			regservice.deleteById(id);
			return "redirect:/showall";
		} else {
			return "redirect:/showall";
		}
	}

	@GetMapping("/update/{id}")
	public String editPage(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("edit", "Edit User Details of ID:" + id);
		// Optional<RegUser> updates = regservice.findById(id);
		RegUser updates = updateservice.get(id);
		model.addAttribute("updates", updates);
		return "/update";

	}

	@PostMapping("/update/{id}")
	public String updated(@ModelAttribute("updt") RegUser updt) {
		regservice.save(updt);
		return "redirect:/showall";
	}
}
