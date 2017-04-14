package com.zml.shsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.shsite.components.exception.UserNotFoundException;
import com.zml.shsite.models.Shuser;
import com.zml.shsite.services.IFileService;
import com.zml.shsite.services.IGoodtypeService;
import com.zml.shsite.services.IUserService;
import com.zml.shsite.viewmodels.RegisterViewModel;
/**
 * 用户管理控制器
 * @author zml
 *
 */
@Controller
@RequestMapping("/UserManager")
public class UserManagerContrlloer {
	@Autowired
	private IGoodtypeService goodtypeService=null;
	@Autowired
	private IUserService userService=null;
	@Autowired
	private IFileService fileService=null;
	//用户管理主页请求
	@RequestMapping
	public String index(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("users", userService.findByRoleId(2));
		return "usermanager/index";
	}
	//用户详情页面请求
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
	//创建用户页面请求
	@RequestMapping("/Create")
	public String create(Model model){
		model.addAttribute("goodTypes", goodtypeService.findAll());
		model.addAttribute("shuser",new Shuser());
		return "usermanager/create";
	}
	//创建
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String create(RegisterViewModel registerViewModel,Model model){
		try{
			Shuser shuser=registerViewModel.toShuser();
			userService.save(shuser,(short)2);
	        fileService.saveOrUpdateUserImage(registerViewModel.getImgFile(),shuser.getShUserId());
			return "redirect:/UserManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "usermanager/create";
		}
	}
	//编辑用户页面请求
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
	//修改用户信息
	@RequestMapping(value="/Edit",
			method=RequestMethod.POST)
	public String edit(RegisterViewModel registerViewModel,Model model){
		try{
			Shuser shuser=registerViewModel.toShuser();
			userService.update(shuser);
			if(!registerViewModel.getImgFile().isEmpty()){
				fileService.saveOrUpdateUserImage(registerViewModel.getImgFile(),shuser.getShUserId());
			}
		    return "redirect:/UserManager";
		}catch(Exception e){
			model.addAttribute("goodTypes", goodtypeService.findAll());
			return "usermanager/edit";
		}
	}
	//删除用户页面请求
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
	//删除用户
	@RequestMapping(value="/Delete",
			method=RequestMethod.POST)
    public String DeleteConfirmed(Integer id)
    {
		if(id==null||userService.findById(id)==null){
			throw new UserNotFoundException();
		}
        userService.removeById(id);
        fileService.deleteUserImage(id);
        return "redirect:/UserManager";
    }
	
}
