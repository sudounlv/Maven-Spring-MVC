package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import com.richardhoppes.example.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(value="/product")
	public String actionTestProduct(Model model) {
		return "test/product";
	}

}
