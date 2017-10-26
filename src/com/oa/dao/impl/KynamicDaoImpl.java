package com.oa.dao.impl;

import com.oa.dao.KynamicDao;
import com.oa.entity.Kynamic;
import com.oa.entity.Version;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017-10-21.
 */
@Repository("kynamicDao")
public class KynamicDaoImpl extends BaseDaoImpl<Kynamic> implements KynamicDao<Kynamic>{
    @Override
    public Kynamic getKynamicByName(String name) {
        List<Kynamic> kynamicList =  this.hibernateTemplate.find("from Kynamic where name=?",name);
        if(kynamicList.size()==0){
            return null;
        }else {
            return kynamicList.get(0);
        }
    }
    public Collection<Kynamic> getSiblingNodes(Long kid) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("from Kynamic");
        stringBuffer.append(" where pid=(");
        stringBuffer.append("select pid from Kynamic where kid=?)");
        return this.hibernateTemplate.find(stringBuffer.toString(),kid);
    }

    public Kynamic getParentNode(Long kid) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("from Kynamic");
        stringBuffer.append(" where kid=(");
        stringBuffer.append("select pid from Kynamic where kid=?)");
        List<Kynamic> kynamicList = this.hibernateTemplate.find(stringBuffer.toString(),kid);
        return kynamicList.get(0);
    }

    @Override
    public Collection<Version> getVersionsByKid(Serializable kid) {
        return this.hibernateTemplate.find("from Version v where v.kynamic.kid=?",kid);
    }

}
