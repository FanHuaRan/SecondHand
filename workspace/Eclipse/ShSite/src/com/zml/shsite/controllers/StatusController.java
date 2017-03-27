package com.zml.shsite.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zml.shsite.services.IGoodtypeService;
@Controller
@RequestMapping("/Status")
public class StatusController {
	private final static Logger logger = Logger.getLogger(StatusController.class);
	@Autowired
	private IGoodtypeService goodtypeService=null;
	
	@RequestMapping("/404")
	public String page404(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "common/404";
	}
	@RequestMapping("/403")
	public String page403(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "common/403";
	}
	@RequestMapping("/500")
	public String page500(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "common/500";
	}
}
