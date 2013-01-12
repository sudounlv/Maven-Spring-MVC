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

	@Autowired
	DeveloperDAO developerDAO;

	@RequestMapping(value="/")
	public @ResponseBody Map<String, String> actionHome(Model model) {
		Map<String, String> retVal = new HashMap<String, String>();
		try {
			retVal.put("mode", settings.getMode());
		} catch (NotFoundException e) {
			retVal.put("mode", "unknown");
		}
		return retVal;
	}

	@RequestMapping(value="/daoJsonTest")
	public @ResponseBody Developer actionTest(Model model) {
		return developerDAO.getDeveloperByApiKey("durr");
	}

}
