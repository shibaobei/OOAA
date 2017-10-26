package com.oa.service;

import com.oa.entity.Menuitem;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-17.
 */
public interface MenuitemService {
    public Collection<Menuitem> getAllMenuitem();
    public Collection<Menuitem> getMenuitemsByPid(Serializable pid);
    public Set<Menuitem> getMenuitemByIDS(Serializable[] ids);
    public Collection<Menuitem> getMenuitemsByUser();
}
