package com.oa.dao;

import com.oa.entity.Menuitem;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-17.
 */
public interface MenuitemDao<T> extends BaseDao<T>{
    public Collection<Menuitem> getMenuitemsByPid(Serializable pid);
    public Set<Menuitem> getMenuitemsByIDS(Serializable[] ids);
    public Collection<Menuitem> getMenuitemsByUser();
}
