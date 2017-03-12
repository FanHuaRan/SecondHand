package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Announcement;
import com.zml.shsite.models.Good;
import com.zml.shsite.models.Shuser;

/**
 * 用户服务:权限、角色、用户
 * @author zml
 *
 */
public interface IUserService {
	Shuser findById(int id);
	Shuser findByUserName(String name);
	List<Shuser> findAll();
	void removeById(int id);
	Shuser save(Shuser shuser);
	Shuser update(Shuser shuser);
}
