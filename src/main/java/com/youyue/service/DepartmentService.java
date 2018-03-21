package com.youyue.service;

import com.youyue.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface DepartmentService {

    /**
     * 查询部门所有对象
     */
    List<Department> findAll();

    /**
     * 根据部门id查询
     * @param depID 要查询的部门id
     */
    Department findById(String depID);

    /**
     * 根据部门id查询带职务集合的部门对象
     */
    Department findPostsByDepId(String depID);

}
