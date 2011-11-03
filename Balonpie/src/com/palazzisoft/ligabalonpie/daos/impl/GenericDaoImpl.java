package com.palazzisoft.ligabalonpie.daos.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.palazzisoft.ligabalonpie.daos.api.GenericDao;

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T,S extends Serializable> extends HibernateDaoSupport implements GenericDao<T, S> {

	protected Class<T> persitenceClass =  getPersistenceClass();	
	

	public T getById(S object) {
		return (T)this.getHibernateTemplate().get(persitenceClass, object);
	}

	public void save(T object) {
		this.getHibernateTemplate().save(object);
	}

	public void update(T object) {
		this.getHibernateTemplate().merge(object);
	}

	protected abstract Class<T> getPersistenceClass();
}
