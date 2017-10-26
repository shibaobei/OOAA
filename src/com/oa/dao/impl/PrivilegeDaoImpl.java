package com.oa.dao.impl;

import com.oa.dao.PrivilegeDao;
import com.oa.dao.UserDao;
import com.oa.entity.Menuitem;
import com.oa.entity.User;
import netscape.security.Privilege;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-18.
 */
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Menuitem> implements PrivilegeDao<Menuitem>{
    @Resource(name="userDao")
    private UserDao userDao;
    @Override
    public Collection<Menuitem> getMenuitemsByUID(Serializable uid) {
        /**
         * 如果是admin则把所有的checked设置为true
         * 如果不是admin，则先便利所有的菜单项，再遍历用户能访问到的所有菜单项，用户能够访问到的checked设为true
         */
        User user = (User)this.userDao.getEntityById(uid);
        Collection<Menuitem> menuitems = this.getAllEntity();
        Collection<Menuitem> menuitemList = this.hibernateTemplate.find("from Menuitem m inner join fetch m.users u where u.uid=?",uid);
        if("admin".equals(user.getUsername())){
            for(Menuitem menuitem:menuitems){
                menuitem.setChecked(true);
            }
        }else{
            for(Menuitem menuitem:menuitems){
                for(Menuitem menuitem1:menuitemList){
                    if(menuitem.getMid().longValue() == menuitem1.getMid().longValue()){
                        menuitem.setChecked(true);
                    }
                }
            }
        }
        return menuitems;
    }
}
