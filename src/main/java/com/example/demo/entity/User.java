package com.example.demo.entity;

import javax.persistence.*;

/**
 * 使用jpa注解配置映射关系
 * @author hujtb
 * @create on 2018-10-30-11:19
 */

@Entity //告诉jpa这是一个实体类（和数据表映射的类）
@Table(name="tbl_user") //用来指定和哪个数据表对应，如果省略，默认为user（类名小写）
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(name="last_name", length=50)
    private String lastName;
    @Column
    private String email;

    //当实体类声明了其他带参构造方法时，需要显式声明不带参构造方法。
    public User(){}
    public User(Integer id, String lastName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
