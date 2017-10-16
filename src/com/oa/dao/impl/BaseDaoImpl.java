package com.oa.dao.impl;

import com.oa.dao.BaseDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-11.
 */
public class BaseDaoImpl<T>  implements BaseDao<T>{
    @Resource(name="hibernateTemplate")
    public HibernateTemplate hibernateTemplate;

    private Class classt;
    /**
     * 1、在父类中要执行一段代码，这个代码的执行时间为子类创建对象的时候，这段代码已经执行完了，根据这个需求，有两种方案供选择
     *      *  利用static语句块
     *      *  利用父类的构造函数
     * 2、分析：
     *      因为得到ParameterizedType需要用到this关键字，而this关键字不能出现在static语句块中
     *    所以只能选择父类的构造器
     */
    public BaseDaoImpl(){
        /**
         * ParameterizedType就是泛型
         */
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        this.classt = (Class)type.getActualTypeArguments()[0];//<T>
        System.out.println(type.getRawType());
    }
    @Override
    public Collection<T> getAllEntity() {
        return this.hibernateTemplate.find("from "+this.classt.getName());
    }

    @Override
    public Object getEntityById(Serializable id) {
        return this.hibernateTemplate.get(this.classt,id);
    }

    @Override
    public void saveEntity(T t) {
        this.hibernateTemplate.save(t);
    }

    @Override
    public void updateEntity(T t) {
        this.hibernateTemplate.update(t);
    }

    @Override
    public void deleteEntity(Serializable id) {
         Object t = this.getEntityById(id);
         this.hibernateTemplate.delete(t);
    }
}
