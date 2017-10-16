package com.oa.service.impl;
import com.oa.dao.PostDao;
import com.oa.entity.Post;
import com.oa.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-14.
 */
@Service("postService")
public class PostServiceImpl implements PostService{
    @Resource(name="postDao")
    private PostDao postDao;
    @Override
    public Collection<Post> getAllPost() {
        return this.postDao.getAllEntity();
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePost(Post post) {
        this.postDao.updateEntity(post);
    }

    @Override
    @Transactional(readOnly = false)
    public void savePost(Post post) {
         this.postDao.saveEntity(post);
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePost(Serializable id) {
          this.postDao.deleteEntity(id);
    }

    @Override
    public Post getPostById(Serializable id) {
        return (Post)this.postDao.getEntityById(id);
    }

    @Override
    public Set<Post> getPostsByPids(Long[] pids) {
        return this.postDao.getPostByIds(pids);
    }
}
