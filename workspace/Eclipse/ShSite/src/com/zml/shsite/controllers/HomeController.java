package com.zml.shsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zml.shsite.models.Announcement;
import com.zml.shsite.models.Good;
import com.zml.shsite.services.IAnnouncementService;
import com.zml.shsite.services.ICreateGoodViewModel;
import com.zml.shsite.services.IGoodService;
import com.zml.shsite.services.IGoodtypeService;
import com.zml.shsite.services.impl.CreateGoodViewModelImpl;
import com.zml.shsite.services.impl.GoodServiceImpl;
import com.zml.shsite.services.impl.GoodtypeServiceImpl;
import com.zml.shsite.test.CreateGoodViewModelTestCase;

@Controller
public class HomeController {
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@Autowired
	private IAnnouncementService announcementService=null;
	@Autowired
	private IGoodService goodService=null;
	@Autowired
	private ICreateGoodViewModel createGoodViewModel=null;
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcements", announcementService.findAll());
		List<Good> goods=goodService.findTopOrderByTime(4);
		model.addAttribute("goods",createGoodViewModel.create(goods));
		return "index";
	}
}
