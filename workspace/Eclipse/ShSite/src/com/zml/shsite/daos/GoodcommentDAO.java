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

import com.zml.shsite.models.Goodcollect;
import com.zml.shsite.models.Goodcomment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goodcomment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Goodcomment
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GoodcommentDAO extends HibernateBaseDao<Goodcomment> {
	// property constants
	public static final String COM_CONTENT = "comContent";
	public static final String COM_TIME = "comTime";
	public  static final String Sh_USER_Id = "shUserId";
	public  static final String GOOD_Id =" goodId";
	@Autowired
	public GoodcommentDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	public List findByComContent(Object comContent) {
		return findByProperty(COM_CONTENT, comContent);
	}
	
	public List findByComTime(Object comContent) {
		return findByProperty(COM_TIME, comContent);
	}
	
	public List<Goodcomment> findByShUserId(int id){
		return findByProperty(Sh_USER_Id, id);
	}
	
	public List<Goodcomment> findByGoodId(int id){
		return findByProperty(GOOD_Id, id);
	}
	
	public void deleteByShUserId(int id){
		 deleteByProperty(Sh_USER_Id, id);
	}
	
	public void deleteByGoodId(int id){
		 deleteByProperty(GOOD_Id, id);
	}
	
	public static GoodcommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodcommentDAO) ctx.getBean("GoodcommentDAO");
	}
}