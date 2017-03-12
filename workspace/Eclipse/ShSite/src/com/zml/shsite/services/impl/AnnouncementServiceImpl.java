package com.zml.shsite.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.shsite.daos.AnnouncementDAO;
import com.zml.shsite.models.Announcement;
import com.zml.shsite.services.IAnnouncementService;
@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
	@Autowired
	private AnnouncementDAO announcementDAO=null;
	@Override
	public Announcement findById(int id) {
		return announcementDAO.findById(id);
	}

	@Override
	public List<Announcement> findAll() {
		return announcementDAO.findAll();
	}

	@Override
	public void removeById(int id) {
		announcementDAO.delete(id);
	}

	@Override
	public void removeAll() {
		announcementDAO.deleteAll();
	}

	@Override
	public Announcement save(Announcement announcement) {
		announcementDAO.save(announcement);
		return announcement;
	}

	@Override
	public Announcement update(Announcement announcement) {
	   announcementDAO.update(announcement);
	   return announcement;
	}

}
