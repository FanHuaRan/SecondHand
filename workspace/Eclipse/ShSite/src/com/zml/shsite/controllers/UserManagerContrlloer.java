package com.zml.shsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.components.exception.UserNotFoundException;
import com.zml.shsite.models.Shuser;
import com.zml.shsite.services.IGoodtypeService;
import com.zml.shsite.services.IUserService;

@Controller
@RequestMapping("/UserManager")
public class UserManagerContrlloer {
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@Autowired
	private IUserService userService=null;
	@Secured({"Admin"})
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("users", userService.findByRoleId(2));
		return "usermanager/index";
	}
	@Secured({"Admin"})
	@RequestMapping("/Details")
	public String details(Integer id,Model model){
		Shuser shuser = null;
		if(id==null||(shuser = userService.findById(id))==null){
			throw new UserNotFoundException();
		}
        model.addAttribute("goodTypes", goodtypeService.findAll());
        model.addAttribute("shuser",shuser);
        return "usermanager/details";
	}
	@Secured({"Admin"})
	@RequestMapping("/Create")
	public String create(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("shuser",new Shuser());
		return "usermanager/create";
	}
	@Secured({"Admin"})
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String create(Shuser shuser,Model model){
		try{
			userService.save(shuser,(short)2);
	        return "redirect:/UserManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "usermanager/create";
		}
	}
	@Secured({"Admin"})
	@RequestMapping("/Edit")
	public String edit(Model model,Integer id){
		Shuser shuser = null;
		if(id==null||(shuser = userService.findById(id))==null){
			throw new UserNotFoundException();
		}
        model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("shuser",shuser);
		return "usermanager/edit";
	}
	@Secured({"Admin"})
	@RequestMapping(value="/Edit",
			method=RequestMethod.POST)
	public String edit(Shuser shuser,Model model){
		try{
			userService.update(shuser);
		    return "redirect:/UserManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "usermanager/edit";
		}
	}
	@Secured({"Admin"})
	@RequestMapping("/Delete")
    public String Delete(Model model,Integer id){
		Shuser shuser = null;
		if(id==null||(shuser = userService.findById(id))==null){
			throw new UserNotFoundException();
		}
        model.addAttribute("goodTypes", goodtypeService.findAll());
        model.addAttribute("shuser",shuser);
        return "usermanager/delete";
    }
	@Secured({"Admin"})
	@RequestMapping(value="/Delete",
			method=RequestMethod.POST)
    public String DeleteConfirmed(Integer id)
    {
		if(id==null||userService.findById(id)==null){
			throw new UserNotFoundException();
		}
        userService.removeById(id);
        return "redirect:/UserManager";
    }
	
}
