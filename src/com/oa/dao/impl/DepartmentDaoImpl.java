package com.oa.dao.impl;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.entity.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-09.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department>{

}
