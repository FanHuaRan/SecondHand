package com.zml.shsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Account")
public class AccountController {
	@RequestMapping("/LogOn")
	public String logOn(){
		return "logon";
	}
	@RequestMapping("/Register")
	public String register(){
		return "register";
	}
	@RequestMapping(value="/Register",
			method=RequestMethod.POST)
	public String registerPost(){
		return "";
	}
}
