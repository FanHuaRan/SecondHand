package com.zml.shsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.components.GoodNotFoundException;
import com.zml.shsite.components.UserNotFoundException;
import com.zml.shsite.models.Good;
import com.zml.shsite.models.Shuser;
import com.zml.shsite.services.IGoodService;
import com.zml.shsite.services.IGoodtypeService;

@Controller
@RequestMapping("/GoodManager")
public class GoodManagerController {
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@Autowired
	private IGoodService goodService=null;
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goods", goodService.findAll());
		return "goodmanager/index";
	}
	@RequestMapping("/Details")
	public String detail(Integer id,Model model){
		Good good=null;
		if(id==null||(good=goodService.findById(id))==null){
			throw new GoodNotFoundException();
		}
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("good", good);
		return "goodmanager/detail";
	}
	@RequestMapping("/Create")
	public String create(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("good",new Good());
		return "goodmanager/create";
	}
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String create(Good good,Model model){
		try{
			goodService.save(good);
	        return "redirect:/UserManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "goodmanager/create";
		}
	}
	@RequestMapping("/Edit")
	public String edit(Model model,Integer id){
		Good good=null;
		if(id==null||(good = goodService.findById(id))==null){
			throw new UserNotFoundException();
		}
        model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("good",good);
		return "goodmanager/edit";
	}
	@RequestMapping(value="/Edit",
			method=RequestMethod.POST)
	public String edit(Good good,Model model){
		try{
			goodService.update(good);
		    return "redirect:/StoreManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "goodmanager/edit";
		}
	}
	@RequestMapping("/Delete")
    public String Delete(Model model,Integer id){
		Good good=null;
		if(id==null||(good = goodService.findById(id))==null){
			throw new UserNotFoundException();
		}
        model.addAttribute("goodTypes", goodtypeService.findAll());
        model.addAttribute("good",good);
        return "goodmanager/delete";
    }
	@RequestMapping(value="/Delete",
			method=RequestMethod.POST)
    public String DeleteConfirmed(Shuser shuser)
    {
		goodService.removeById(shuser.getShUserId());
        //采用重定向
        return "redirect:/GoodManager";
    }
}
