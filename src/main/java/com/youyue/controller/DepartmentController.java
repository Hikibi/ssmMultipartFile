package com.youyue.controller;

import com.youyue.domain.Department;
import com.youyue.domain.Post;
import com.youyue.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 在类上面定义的 @RequestMapping注解 代表该类中的所有方法前都需要加的路径
 * 相当于 Struts2 中的 package
 */
@Controller
@RequestMapping("/hr")
public class DepartmentController {

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询部门集合
     * 返回json数据
     * 访问地址: /hr/findAll
     */
    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    /**
     * 根据部门id查询职务集合
     * 返回json数据
     * 访问地址: /hr/findPostsByDepId
     */
    @ResponseBody
    @RequestMapping(value = "/findPostsByDepId")
    public List<Post> findPostsByDepId(String depId) {

        System.out.println("要查找的部门ID" + depId);

        Department department = departmentService.findPostsByDepId(depId);

        if (department != null) {

            return department.getPostList();    // 返回职务集合

        } else {

            return null;

        }
    }

}
