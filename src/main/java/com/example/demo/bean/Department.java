package com.example.demo.bean;

import java.io.Serializable;

/**
 * @author hujtb
 * @create on 2018-10-29-17:17
 */

public class Department implements Serializable{
    private Integer id;
    private String departmentName;

    public Department(){super();}
    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
