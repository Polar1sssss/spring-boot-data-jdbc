package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJdbcApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate; //KV都是字符串

	@Autowired
	RedisTemplate redisTemplate; //KV都是对象

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	public void test01(){
		Employee employee = employeeMapper.getEmpById(1);
		redisTemplate.delete("emp1");
		empRedisTemplate.opsForValue().set("emp1", employee);
		System.out.println(redisTemplate.opsForValue().get("emp1"));
	}

	@Test
	public void contextLoads() throws SQLException {
		Employee employee = employeeMapper.getEmpById(1);
	}

}
