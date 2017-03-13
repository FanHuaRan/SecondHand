package com.zml.shsite.daos;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zml.shsite.models.Shrole;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shrole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Shrole
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ShroleDAO extends HibernateBaseDao<Shrole> {
	// property constants
	public static final String SH_ROLE_NAME = "shRoleName";
	
	@Autowired
	public ShroleDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	public List findByShRoleName(Object shRoleName) {
		return findByProperty(SH_ROLE_NAME, shRoleName);
	}

	public static ShroleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShroleDAO) ctx.getBean("ShroleDAO");
	}
}