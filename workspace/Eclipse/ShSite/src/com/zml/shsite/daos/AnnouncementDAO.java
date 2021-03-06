package com.zml.shsite.daos;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zml.shsite.models.Announcement;

/**
 * A data access object (DAO) providing persistence and search support for
 * Announcement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Announcement
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AnnouncementDAO extends HibernateBaseDao<Announcement> {
	// property constants
	public static final String ANNO_CONTENT = "annoContent";
	public static final String ANNOUNCE_TITLE = "announceTitle";
	@Autowired
	public AnnouncementDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	public List findByAnnoContent(Object annoContent) {
		return findByProperty(ANNO_CONTENT, annoContent);
	}

	public List findByAnnounceTitle(Object announceTitle) {
		return findByProperty(ANNOUNCE_TITLE, announceTitle);
	}
	public static AnnouncementDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AnnouncementDAO) ctx.getBean("AnnouncementDAO");
	}
}