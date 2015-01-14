package com.palazzisoft.ligabalonpie.daos.api;
/**
 * 
 * @author ppalazzi
 *
 * @param <T>
 * @param <S>
 */
public interface GenericDao<T,S> {

	T getById(S object);
	void save(T object);
	void update(T object);
	void delete(T object);
}
