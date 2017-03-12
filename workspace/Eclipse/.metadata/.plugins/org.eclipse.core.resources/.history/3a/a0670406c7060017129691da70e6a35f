package pers.fhr.musicstore.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.Person;

import pers.fhr.musicstore.services.IUserService;

public class CustomUserDetailsServiceImpl implements UserDetailsService {
	private static Logger logger = Logger.getLogger(CustomUserDetailsServiceImpl.class);
	@Autowired
	private IUserService userService=null;
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		String password=userService.findUserPassword(arg0);
		if(password==null||password.equals("")){
			logger.info("wrong user:"+arg0);
			 throw new UsernameNotFoundException("Username not found");  
		}  return new org.springframework.security.core.userdetails.User(arg0,password,   
                true, true, true, true, getGrantedAuthorities(arg0,password));  
	}
	//权限在Spring Security中是以我们平常认为的角色来体现的
    private List<GrantedAuthority> getGrantedAuthorities(String userName,String password){ 
        //实例化权限集合
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        //获取角色到集合中 一个人可能由多种角色 不太支持 
       authorities.add(new SimpleGrantedAuthority(userService.findUserRole(userName, password))); 
        System.out.print("authorities :"+authorities);  
        return authorities;  
    }  

}
