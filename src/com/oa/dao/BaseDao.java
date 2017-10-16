package com.oa.dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-11.
 */
public interface BaseDao<T> {
    public Collection<T> getAllEntity();
    public Object getEntityById(Serializable id);
    public void saveEntity(T t);
    public  void updateEntity(T t);
    public void deleteEntity(Serializable id);
}
