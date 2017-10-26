package com.oa.dao;

import com.oa.entity.Kynamic;
import com.oa.entity.Version;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-20.
 */
public interface KynamicDao<T> extends BaseDao<T>{
    public Kynamic getKynamicByName(String name);
    public Collection<Kynamic> getSiblingNodes(Long kid);
    public Kynamic getParentNode(Long kid);
    public Collection<Version> getVersionsByKid(Serializable kid);

}
