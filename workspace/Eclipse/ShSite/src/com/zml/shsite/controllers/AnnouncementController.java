package com.zml.shsite.controllers;

import java.sql.Timestamp;

import javax.jws.WebParam.Mode;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.components.exception.AnnounceNotFoundException;
import com.zml.shsite.models.Announcement;
import com.zml.shsite.services.IAnnouncementService;
import com.zml.shsite.services.IGoodtypeService;
/**
 * 与公告相关的控制器
 * @author zml
 *
 */
@Controller
@RequestMapping("/Announcement")
public class AnnouncementController {
	private static final Logger logger=Logger.getLogger(AnnouncementController.class);
	@Autowired
	private IAnnouncementService announcementService=null;
	@Autowired
	private IGoodtypeService goodtypeService=null;
	//公告主页面请求
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcements", announcementService.findAll());
		return "anno/index";
	}
	//公告详细页面请求
	@RequestMapping("/Details")
	public String details(Integer id,Model model){
		Announcement announcement=null;
		if(id==null||(announcement=announcementService.findById(id))==null){
			throw new AnnounceNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcement",announcement);
		return "anno/details";
	}
	//公告管理页面请求
	@RequestMapping("/Manager")
	public String manager(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcements", announcementService.findAll());
		return "anno/manager";
	}
	//创建公告页面请求
	@RequestMapping("/Create")
	public String create(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		return "anno/create";
	}
	//创建公告
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String createAnnoPost(Announcement announcement){
		try{
			announcement.setAnnoTime(new Timestamp(System.currentTimeMillis()));
			announcementService.save(announcement);
			return "redirect:/Announcement/Manager";
		}catch (Exception e) {
			logger.error(e.getMessage());
			return "anno/create";
		}
	}
	//修改公告页面请求
	@RequestMapping("/Edit")
	public String edit(Integer id,Model model){
		Announcement announcement=null;
		if(id==null||(announcement=announcementService.findById(id))==null){
			throw new AnnounceNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcement",announcement);
		return "anno/edit";
	}
	//修改公告
	@RequestMapping(value="/Edit",
					method=RequestMethod.POST)
	public String editAnnoPost(Announcement announcement){
		try{
			announcementService.update(announcement);
			return "redirect:/Announcement/Manager";
		}catch (Exception e) {
			logger.error(e.getMessage());
			return "anno/edit";
		}
	}
	//删除公告页面确认请求
	@RequestMapping("/Delete")
	public String delete(Integer id,Model model){
		Announcement announcement=null;
		if(id==null||(announcement=announcementService.findById(id))==null){
			throw new AnnounceNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("announcement",announcement);
		return "anno/delete";
	}
	//删除公告
	@RequestMapping(value="/DeleteConfirm",
				    method=RequestMethod.POST)
	public String deleteAnno(Integer id){
		if(id==null||announcementService.findById(id)==null){
			throw new AnnounceNotFoundException();
		}
		announcementService.removeById(id);
		return "redirect:/Announcement/Manager";
	}
}
