package com.oa.dao.impl;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.entity.User;
import com.oa.utils.DeleteMode;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-09.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{
    @Override
    public void saveDepartment(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        this.getHibernateTemplate().update(department);
    }

    @Override
    public void deleteDepartmentById(Serializable id, DeleteMode deleteMode) {
        Department department = this.getDepartmentById(id);
        if("del".equals(deleteMode.DEL)){//单表的删除
            this.getHibernateTemplate().delete(department);
        }else if("del_pre_release".equals(deleteMode.DEL_PRE_RELEASE)){//删除前解除关系
            Set<User> users = department.getUsers();
            for(User user:users){
                user.setDepartment(null);
            }
        }else{//级联删除

        }

    }

    @Override
    public Collection<Department> getAllDepartment() {
        return this.getHibernateTemplate().find("from com.oa.entity.Department");

    }

    @Override
    public Department getDepartmentById(Serializable id) {
        return (Department)this.getHibernateTemplate().get(DepartmentDao.class,id);
    }
}
