package com.oa.dao;

import com.oa.entity.Menuitem;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-18.
 */
public interface PrivilegeDao<T> extends BaseDao<T>{
     public Collection<Menuitem> getMenuitemsByUID(Serializable uid);
 }
