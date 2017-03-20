package com.zml.shsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.components.exception.GoodNotFoundException;
import com.zml.shsite.components.exception.GoodtypeNotFoundException;
import com.zml.shsite.models.Good;
import com.zml.shsite.models.Goodcollect;
import com.zml.shsite.models.Goodcomment;
import com.zml.shsite.services.IGoodService;
import com.zml.shsite.services.IGoodtypeService;
import com.zml.shsite.services.impl.GoodServiceImpl;
import com.zml.shsite.services.impl.GoodtypeServiceImpl;

@Controller
@RequestMapping("/Good")
public class GoodController {
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@Autowired
	private IGoodService goodService=null;
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("goods", goodService.findAll());
		return "good/index";
	}
	
	@RequestMapping("/Browse")
	public String browse(Integer id,Model model){
		if(id==null){
			throw new GoodtypeNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("goods", goodService.findByGoodType(id));
		return "good/browse";
	}
	
	@RequestMapping("/Details")
	public String details(Integer id,Model model){
		Good good=null;
		if(id==null||(good=goodService.findById(id))==null){
			throw new GoodNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("good", good);
		return "good/details";
	}
	//商品收藏post
	@RequestMapping(value="/GoodCollect",
					method=RequestMethod.POST)
	public String goodCollect(Goodcollect goodcollect){
		return null;
	}
	//商品评论post
	@RequestMapping(value="/GoodComment",
						method=RequestMethod.POST)
	public String goodComment(Goodcomment goodcomment){
		return null;
	}
}
