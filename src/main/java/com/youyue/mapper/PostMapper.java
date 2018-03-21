package com.youyue.mapper;

import com.youyue.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface PostMapper {

    List<Post> findAll();

    /**
     * 根据职务id查询职务对象
     */
    Post findById(String postId);

}
