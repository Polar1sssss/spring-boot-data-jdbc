package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hujtb
 * @create on 2018-10-29-18:19
 */

@Controller
@ResponseBody
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        Department dept = departmentService.getDeptById(id);
        return dept;
    }

    /*@GetMapping("/insdept")
    public Department insertDept(Department department){
        departmentService.insertDept(department);
        return department;
    }*/

    @GetMapping("/upddept")
    public Department updateDept(Department department){
        departmentService.updateDept(department);
        return department;
    }

    @GetMapping("/dept/lastName/{lastName}")
    public Department getDeptByLastName(@PathVariable("lastName") String lastName){
        Department dept = departmentService.getDeptByLastName(lastName);
        return dept;
    }

    @GetMapping("/deldept/{id}")
    public String deleteDept(@PathVariable("id") Integer id){
        departmentService.deleteDept(id);
        return "success";
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee insertDept(Employee employee){
        employeeMapper.insertEmp(employee);
        return employee;
    }
}
