package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

public interface GenericDao<T,S> {

	public T getById(S object);
	public void save(T object);
	public void update(T object);
}
