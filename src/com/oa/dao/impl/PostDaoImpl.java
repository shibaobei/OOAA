package com.oa.dao.impl;

import com.oa.dao.PostDao;
import com.oa.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-13.
 */
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao<Post>{
    @Override
    public Set<Post> getPostByIds(Long[] pids) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("from Post");
        stringBuffer.append(" where pid in(");
        for(int i=0;i<pids.length;i++){
            if(i<pids.length - 1){
                stringBuffer.append(pids[i]+",");
            }else{
                stringBuffer.append(pids[i]);
            }
        }
        stringBuffer.append(")");
        List<Post> postList = this.hibernateTemplate.find(stringBuffer.toString());
        return new HashSet<Post>(postList);
    }
}
