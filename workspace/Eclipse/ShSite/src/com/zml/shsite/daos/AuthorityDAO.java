package com.zml.shsite.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.zml.shsite.models.Authority;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zml.shsite.models.Authority
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AuthorityDAO extends HibernateBaseDao<Authority> {
	public static final String SH_ROLE_Id = "shRoleId";
	public static final String Sh_USER_Id =" shUserId";
	@Autowired
	public AuthorityDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	public List<Authority> findByShRoleId(int id){
		return findByProperty(SH_ROLE_Id, id);
	}
	public List<Authority> findByShUserId(int id){
		return findByProperty(Sh_USER_Id, id);
	}
	public void deleteByShRoleId(int id){
		 deleteByProperty(SH_ROLE_Id, id);
	}
	public void deleteByShUserId(int id){
		 deleteByProperty(Sh_USER_Id, id);
	}
	public static AuthorityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AuthorityDAO) ctx.getBean("AuthorityDAO");
	}
}