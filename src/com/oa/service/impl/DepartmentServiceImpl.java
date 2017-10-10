package com.oa.service.impl;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.service.DepartmentService;
import com.oa.utils.DeleteMode;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentDao.saveDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
       this.departmentDao.updateDepartment(department);
    }

    @Override
    public void deleteDepartmentById(Serializable id, DeleteMode deleteMode) {
         this.departmentDao.deleteDepartmentById(id,deleteMode);
    }

    @Override
    public Collection<Department> getAllDepartment() {
        return this.departmentDao.getAllDepartment();
    }

    @Override
    public Object getDepartmentById(Serializable id) {
        return this.departmentDao.getDepartmentById(id);
    }
}
