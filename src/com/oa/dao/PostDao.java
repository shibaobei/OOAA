package com.oa.dao;

import com.oa.entity.Post;

import java.util.Set;

/**
 * Created by Administrator on 2017-10-13.
 */
public interface PostDao<T> extends BaseDao<T> {
    public Set<Post> getPostByIds(Long[] pids);
}
