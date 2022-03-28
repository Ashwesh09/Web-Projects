package com.springwebmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/add")
public class AddtionController {
	/**
	 * @param num1
	 * @param num2
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)   
    public String display(@RequestParam(defaultValue="0") String num1,@RequestParam(defaultValue="0") String num2,ModelMap model)  
    {  
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);  
        model.addAttribute("message", "Result : "+ (n1+n2));  
        return "add";       
    }  
}