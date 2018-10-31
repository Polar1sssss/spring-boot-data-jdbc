package com.example.demo.mapper;

import com.example.demo.bean.Employee;

/**
 * 使用配置文件开发mybatis
 * @author hujtb
 * @create on 2018-10-30-9:57
 */

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public int insertEmp(Employee employee);
}
