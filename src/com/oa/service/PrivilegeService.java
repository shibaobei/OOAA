package com.oa.service;

import com.oa.entity.Menuitem;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-18.
 */
public interface PrivilegeService {
    public Collection<Menuitem> getPrivileges(Serializable uid);
}
