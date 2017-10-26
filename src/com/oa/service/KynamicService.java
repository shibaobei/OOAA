package com.oa.service;

import com.oa.entity.Kynamic;
import com.oa.entity.Version;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-21.
 */
public interface KynamicService {
    public Collection<Kynamic> getAllKynamic();
    public void saveKynamic(Kynamic kynamic);
    public Kynamic getKynamicById(Long kid);
    public boolean exsitName(String name);
    public void deleteKynamicById(Serializable kid);
    public Collection<Kynamic> getSiblingsNodes(Long kid);
    public Kynamic getParentNode(Long kid);
    public void updateKynamic(Kynamic kynamic);
    public Collection<Version> getVersionsByKid(Serializable kid);
}
