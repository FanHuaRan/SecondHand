package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Announcement;

public interface IAnnouncementService {
	Announcement findById(int id);
	List<Announcement> findAll();
	void removeById(int id);
	void removeAll();
	Announcement save(Announcement announcement);
	Announcement update(Announcement announcement);
}
