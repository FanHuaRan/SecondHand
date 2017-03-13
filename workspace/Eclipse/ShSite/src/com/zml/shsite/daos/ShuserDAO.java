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

import com.zml.shsite.models.Shuser;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shuser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Shuser
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ShuserDAO extends HibernateBaseDao<Shuser> {
	// property constants
	public static final String SH_USER_NAME = "shUserName";
	public static final String PASSWORD = "password";
	public static final String GENDER = "gender";
	public static final String INTRODUCE = "introduce";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	
	@Autowired
	public ShuserDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	public List findByShUserName(Object shUserName) {
		return findByProperty(SH_USER_NAME, shUserName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByIntroduce(Object introduce) {
		return findByProperty(INTRODUCE, introduce);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public static ShuserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShuserDAO) ctx.getBean("ShuserDAO");
	}
}