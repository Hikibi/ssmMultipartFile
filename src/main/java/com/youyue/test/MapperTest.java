package com.youyue.test;

import com.youyue.domain.Department;
import com.youyue.domain.Post;
import com.youyue.mapper.DepartmentMapper;
import com.youyue.service.DepartmentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class MapperTest {

    private ApplicationContext context;
    private DepartmentMapper departmentMapper;
    private DepartmentService departmentService;

    @Before
    public void init() {
//        启动spring容器
        context = new ClassPathXmlApplicationContext("spring-config.xml");

        departmentMapper = (DepartmentMapper) context.getBean("departmentMapper");

        departmentService = (DepartmentService) context.getBean("departmentService");
    }

    @After
    public void destroy() {

    }

    @Test
    public void testDepart() {

        System.out.println(departmentMapper);

//        departmentMapper.findAll();

        Department postsByDepId = departmentMapper.findPostsByDepId("2c90906e5f5658e5015f565923d80000");

        System.out.println(postsByDepId);

        for (Post post : postsByDepId.getPostList()) {
            System.out.println(post);
        }


    }

    @Test
    public void testDepartmentService() {

        List<Department> all = departmentService.findAll();

        for (Department depart : all) {
            System.out.println(depart);

            Department department = departmentService.findPostsByDepId(depart.getDepID());

            if (department != null) {

                System.out.println(department.getPostList());

            }


        }

    }


}
