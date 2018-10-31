package com.example.demo.service;

import com.example.demo.bean.Department;
import com.example.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * 默认使用ConcurrentMapCache组件，将数据保存在ConcurrentHashMap中
 * @author hujtb
 * @create on 2018-10-30-16:27
 */

@CacheConfig(cacheNames = "dept")
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * @Cacheable：将方法运行的结果缓存
     * 属性：
     *      cacheNames/value：指定缓存名字
     *      key：缓存数据时使用的key
     *      keyGenerator：key的生成器，可以自己指定生成器组件的id
     *          key和keyGenerator二选一
     *      cacheManager：缓存管理器
     *      caceResovler：缓存解析器
     *      condition：指定符合条件情况下才缓存
     *          condition = "#id>0"
     *      unless：否定缓存，当unless表达式为true，方法返回值不会缓存，可以获取到结果进行判断
     *          unless = "#result == null"
     *      sync：缓存是否使用异步模式
     *
     *      @Cacheable运行流程
     *      1.方法运行之前先查询Cache（缓存组件），按照cacheNames指定的名字获取（ConcurrentMapCacheManager）
     *      2.通过一个key去Cache中查找缓存内容，默认就是方法的参数，key是按照某种策略生成的，
     *          默认使用SimpleKeyGenerator生成key
     *      3.没有查询到缓存就调用目标方法
     *      4.将目标方法返回结果放到缓存中
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    public Department getDeptById(Integer id){
        System.out.println("查询" + id +"号员工");
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }

    /**
     * @CachePut：既调用方法，又更新缓存（同步更新缓存）
     * 常见场景：修改数据库某个数据，同时更新缓存
     * 运行时机：
     *      1、先调用目标方法
     *      2、将目标方法运行结果放到缓存中
     * 需要保证查询缓存的key和更新缓存的key保持一致，否则无法更新（查询缓存的key是id，而更新缓存的key是employmee）
     * @param department
     * @return
     */
    @CachePut(key = "#result.id")
    public Department updateDept(Department department){
        System.out.println("员工更新方法调用");
        departmentMapper.updateDept(department);
        return department;
    }

    /**
     * @CacheEvict：清楚缓存
     * 属性：
     *      allEntries = true：指定清除这个缓存中的所有数据
     *      beforeInvocation = false：缓存的清除在调用方法之后执行
     * @param id
     * @return
     */
    @CacheEvict(key = "#id")
    public void deleteDept(Integer id){
        departmentMapper.deleteDept(id);
    }

    /**
     * @Caching：定义复杂的缓存规则
     * 因为@CachePut注解标注的key是id，所以按照lastName查询的时候不会走缓存
     * @param lastName
     * @return
     */
    @Caching(
        cacheable = {
            @Cacheable(key = "#lastName")
        },
        put = {
            @CachePut(key = "#result.id")
        }
    )
    public Department getDeptByLastName(String lastName){
        Department dept = departmentMapper.getDeptByLastName(lastName);
        return dept;
    }

    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
