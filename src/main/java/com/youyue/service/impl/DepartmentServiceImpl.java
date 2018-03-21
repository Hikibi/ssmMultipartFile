package com.youyue.service.impl;

import com.youyue.domain.Department;
import com.youyue.mapper.DepartmentMapper;
import com.youyue.service.DepartmentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    public Department findById(String depID) {
        return departmentMapper.findById(depID);
    }

    public Department findPostsByDepId(String depID) {
        return departmentMapper.findPostsByDepId(depID);
    }
}
