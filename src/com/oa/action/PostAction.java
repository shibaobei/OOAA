package com.oa.action;

import com.oa.entity.Post;
import com.oa.service.PostService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-14.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post>{
    @Resource(name="postService")
    private PostService postService;
    public String getAllPost(){
        Collection<Post>  postList = this.postService.getAllPost();
        ActionContext.getContext().put("postList",postList);
        return listAction;
    }
    public String addUI(){
        return addUI;
    }
    public String add(){
        Post post = new Post();
        BeanUtils.copyProperties(this.getModel(),post);
        this.postService.savePost(post);
        return action2action;
    }
    public String delete(){
        this.postService.deletePost(this.getModel().getPid());
        return action2action;
    }
    public String updateUI(){
        Post post =  this.postService.getPostById(this.getModel().getPid());
        ActionContext.getContext().getValueStack().pop();
        ActionContext.getContext().getValueStack().push(post);
        return updateUI;
    }
    public String update(){
        Post post = this.postService.getPostById(this.getModel().getPid());
        BeanUtils.copyProperties(this.getModel(),post);
        this.postService.updatePost(post);
        return action2action;
    }
}
