package com.zml.shsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.models.Announcement;
import com.zml.shsite.services.IAnnouncementService;
import com.zml.shsite.services.IGoodtypeService;

@Controller
@RequestMapping("/Announcement")
public class AnnouncementController {
	@Autowired
	private IAnnouncementService announcementService=null;
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcements", announcementService.findAll());
		return "anno/create";
	}
	//创建公告
	@RequestMapping("/create")
	public String createAnnoPost(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "anno/create";
	}
	//创建公告post
	@RequestMapping(value="/create",
					method=RequestMethod.POST)
	public String createAnnoPost(Announcement announcement){
		return null;
	}
	//修改公告
	@RequestMapping("/Edit")
	public String editAnnoPost(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "anno/edit";
	}
	//修改公告post
	@RequestMapping(value="/Edit",
					method=RequestMethod.POST)
	public String editAnnoPost(Announcement announcement){
		return null;
	}
	//删除公告post
	@RequestMapping(value="/delete",
			method=RequestMethod.POST)
	public String deleteAnno(Integer id){
		announcementService.removeById(id);
		return "redirect:/Announcement";
	}
}