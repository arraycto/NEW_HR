package com.ln.hr.service;

import com.ln.hr.mapper.DepartmentMapper;
import com.ln.hr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }
}
