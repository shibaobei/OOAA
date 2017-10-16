package com.oa.service;

import com.oa.entity.Department;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
public interface DepartmentService {
    public void saveDepartment(Department department);
    public void updateDepartment(Department department);
    public void deleteDepartmentById(Serializable id, String DeleteMode);
    public Collection<Department> getAllDepartment();
    public Department getDepartmentById(Serializable id);
}
