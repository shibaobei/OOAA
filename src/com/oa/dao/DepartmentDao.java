package com.oa.dao;

import com.oa.entity.Department;
import com.oa.utils.DeleteMode;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
public interface DepartmentDao {
    public void saveDepartment(Department department);
    public void updateDepartment(Department department);
    public void deleteDepartmentById(Serializable id, DeleteMode deleteMode);
    public Collection<Department> getAllDepartment();
    public Object getDepartmentById(Serializable id);
}
