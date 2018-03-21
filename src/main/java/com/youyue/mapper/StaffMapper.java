package com.youyue.mapper;

import com.youyue.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffMapper {

    /**
     * 查询所有员工
     */
    List<Staff> findAll();

    /**
     * 根据员工id查询职务对象
     */
    Staff findById(String staffId);

}
