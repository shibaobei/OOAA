package com.oa.service;

import com.oa.entity.Post;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-14.
 */
public interface PostService {
    public Collection<Post> getAllPost();
    public void updatePost(Post post);
    public void savePost(Post post);
    public void deletePost(Serializable id);
    public Post getPostById(Serializable id);
    public Set<Post> getPostsByPids(Long[] pids);

}
