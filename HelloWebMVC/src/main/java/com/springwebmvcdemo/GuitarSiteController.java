package com.springwebmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/guitar")
public class GuitarSiteController {
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		return "guitar";
	}
}