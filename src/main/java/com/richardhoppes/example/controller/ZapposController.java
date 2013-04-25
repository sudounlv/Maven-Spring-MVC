package com.richardhoppes.example.controller;

import com.richardhoppes.example.common.Settings;
import com.richardhoppes.example.exception.ResourceNotFoundException;
import com.richardhoppes.example.model.Product;
import com.richardhoppes.example.service.ZapposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZapposController extends AbstractJsonController {

	@Autowired
	Settings settings;

	@Autowired
	ZapposService zapposService;

	@RequestMapping(value = "/zappos/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody
	Product actionGetProduct(@PathVariable Integer productId) throws ResourceNotFoundException {
		Product product = zapposService.getProductInfo(productId);

		if(product == null) {
			throw new ResourceNotFoundException("Product not found");
		}

		return product;
	}

}
