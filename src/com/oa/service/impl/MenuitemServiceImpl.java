package com.oa.service.impl;

import com.oa.dao.MenuitemDao;
import com.oa.entity.Menuitem;
import com.oa.service.MenuitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-17.
 */
@Service("menuitemService")
public class MenuitemServiceImpl implements MenuitemService{
    @Resource(name="menuitemDao")
    private MenuitemDao menuitemDao;
    public Collection<Menuitem> getAllMenuitem(){
          return this.menuitemDao.getAllEntity();
    }

    @Override
    public Collection<Menuitem> getMenuitemsByPid(Serializable pid) {
        return this.menuitemDao.getMenuitemsByPid(pid);
    }

    @Override
    public Set<Menuitem> getMenuitemByIDS(Serializable[] ids) {
        return this.menuitemDao.getMenuitemsByIDS(ids);
    }
    public Collection<Menuitem> getMenuitemsByUser() {
        return this.menuitemDao.getMenuitemsByUser();
    }
}
