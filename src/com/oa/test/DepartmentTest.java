package com.oa.test;

import com.oa.entity.Department;
import com.oa.service.DepartmentService;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
public class DepartmentTest extends BaseSpring{
    @Test
    public void testQuery(){
        DepartmentService departmentSerice = (DepartmentService)context.getBean("departmentService");
        Collection<Department> departments = departmentSerice.getAllDepartment();
    }
}
