package com.oa.service.impl;

import com.oa.dao.KynamicDao;
import com.oa.entity.Kynamic;
import com.oa.entity.Version;
import com.oa.service.KynamicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-21.
 */
@Service("kynamicService")
public class KynamicServiceImpl implements KynamicService{
    @Resource(name="kynamicDao")
    private KynamicDao kynamicDao;
    @Override
    public Collection<Kynamic> getAllKynamic() {
        return this.kynamicDao.getAllEntity();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveKynamic(Kynamic kynamic) {
        this.kynamicDao.saveEntity(kynamic);
    }

    @Override
    public boolean exsitName(String name) {
        Kynamic kynamic =  this.kynamicDao.getKynamicByName(name);
        return kynamic!=null?true:false;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteKynamicById(Serializable kid) {
        this.kynamicDao.deleteEntity(kid);
    }
    public Collection<Kynamic> getSiblingsNodes(Long kid) {
        return this.kynamicDao.getSiblingNodes(kid);
    }

    public Kynamic getParentNode(Long kid) {
        return this.kynamicDao.getParentNode(kid);
    }

    @Transactional(readOnly=false)
    public void updateKynamic(Kynamic kynamic) {
        this.kynamicDao.updateEntity(kynamic);
    }

    @Override
    public Collection<Version> getVersionsByKid(Serializable kid) {
        return this.kynamicDao.getVersionsByKid(kid);
    }

    public Kynamic getKynamicById(Long kid) {
        return (Kynamic)this.kynamicDao.getEntityById(kid);
    }
}
