package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	Settings settings;

	@RequestMapping(value="/")
	public String actionHome(Model model) {
		model.addAttribute("mode", settings.getMode());
		return "home";
	}

}
