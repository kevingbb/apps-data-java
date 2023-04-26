package com.appsdata.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws Exception {
		model.addAttribute("name", name);
		// Create HTTP 500 Error 5 percent of the time
		boolean buggy = Boolean.parseBoolean(System.getenv("BUGGY"));
		if (buggy == true && Math.random() < 0.05) {
			throw new Exception("BUGGY");
		}

		return "greeting";
	}

}