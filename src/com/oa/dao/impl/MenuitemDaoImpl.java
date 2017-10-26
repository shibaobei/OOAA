package com.oa.dao.impl;

import com.oa.dao.MenuitemDao;
import com.oa.entity.Menuitem;
import com.oa.entity.User;
import com.oa.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-17.
 */
@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao<Menuitem>{
    @Override
    public Collection<Menuitem> getMenuitemsByPid(Serializable pid) {
        return this.hibernateTemplate.find("from com.oa.entity.Menuitem where pid = ?",pid);
    }

    @Override
    public Set<Menuitem> getMenuitemsByIDS(Serializable[] ids) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("from Menuitem ");
        stringBuffer.append("where mid in(");
        for(int i=0;i<ids.length;i++){
            if(i<ids.length-1){
                stringBuffer.append(ids[i]+",");
            }else{
                stringBuffer.append(ids[i]);
            }
        }
        stringBuffer.append(")");
        List<Menuitem> menuitems = this.hibernateTemplate.find(stringBuffer.toString());
        return new HashSet<Menuitem>(menuitems);
    }
    public Collection<Menuitem> getMenuitemsByUser() {
        User user = StringUtil.fromSession();
        if("admin".equals(user.getUsername())){
            return this.getAllEntity();
        }else{
            return this.hibernateTemplate.find("from Menuitem m inner join fetch m.users u where u.uid=?",user.getUid());
        }
    }
}
