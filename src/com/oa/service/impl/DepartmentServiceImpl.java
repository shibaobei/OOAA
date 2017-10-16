package com.oa.service.impl;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
   @Resource(name="departmentDao")
    private DepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = false)
    public void saveDepartment(Department department) {
        this.departmentDao.saveEntity(department);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateDepartment(Department department) {
       this.departmentDao.updateEntity(department);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteDepartmentById(Serializable id, String deleteMode) {
         this.departmentDao.deleteEntity(id);
    }

    @Override
    public Collection<Department> getAllDepartment() {
        return this.departmentDao.getAllEntity();
    }

    @Override
    public Department getDepartmentById(Serializable id) {
        return (Department)this.departmentDao.getEntityById(id);
    }
}
