package com.oa.service.impl;

import com.oa.dao.PrivilegeDao;
import com.oa.entity.Menuitem;
import com.oa.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-18.
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService{
    @Resource(name="privilegeDao")
    private PrivilegeDao privilegeDao;
    @Override
    public Collection<Menuitem> getPrivileges(Serializable uid) {
        return this.privilegeDao.getMenuitemsByUID(uid);
    }
}
