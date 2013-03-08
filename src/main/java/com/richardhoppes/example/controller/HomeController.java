package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import com.richardhoppes.example.dao.DeveloperDAO;
import com.richardhoppes.example.exception.NotFoundException;
import com.richardhoppes.example.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

	@Autowired
	Settings settings;

	@RequestMapping(value={"/", "/settings"})
	public String actionJspTest(Model model) {
		try {
			model.addAttribute("mode", settings.getMode());
		} catch (NotFoundException ex) {
			model.addAttribute("mode", "unknown");
		}
		return "home/settings";
	}

	@RequestMapping(value="/settings.json")
	public @ResponseBody Map<String, String> actionJsonTest() {
		Map<String, String> retMap = new HashMap<String, String>();
		try {
			retMap.put("mode", settings.getMode());
		} catch (NotFoundException ex) {
			retMap.put("mode", "unknown");
		}
		return retMap;
	}

}
