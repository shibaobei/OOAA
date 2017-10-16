package com.oa.action;

import com.oa.dao.DepartmentDao;
import com.oa.dao.PostDao;
import com.oa.entity.Department;
import com.oa.entity.Post;
import com.oa.entity.User;
import com.oa.service.DepartmentService;
import com.oa.service.PostService;
import com.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-15.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAtion extends BaseAction<User>{
    @Resource(name="userService")
    private UserService userService;
    @Resource(name="departmentService")
    private DepartmentService departmentService;
    @Resource(name="postService")
    private PostService postService;

    private Long did;
    private Long[] pids;
    private String message;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Long[] getPids() {
        return pids;
    }

    public void setPids(Long[] pids) {
        this.pids = pids;
    }

    public String getMessage() {
        return message;
    }

    public String getAllUser(){
        Collection<User> userList = this.userService.getAllUser();
        ActionContext.getContext().getValueStack().push(userList);
        return listAction;
    }
    public String addUI(){
        //把部门表的数据查询出来
        Collection<Department> departmentList = this.departmentService.getAllDepartment();
        //把岗位表的数据查询出来
        Collection<Post> postList = this.postService.getAllPost();
        //跳转到增加页面
        ActionContext.getContext().put("departmentList",departmentList);
        ActionContext.getContext().put("postList",postList);
        return addUI;
    }
    public String add(){
        /**
         * 如何获取页面中的数据
         *    * 如果页面中的数据来源于一张表，直接用模型驱动获取数据
         *    *如果页面中的数据来源于多张表，则可以采用模型驱动结合属性驱动
         */
        /**
         * 创建一个user对象
         * 把模型驱动的值给user队形
         * 根据did获取该部门
         * 根据pids提取岗位
         * 建立user对象和部门、岗位之间的联系
         * 执行save操作
         */
        User user = new User();
        BeanUtils.copyProperties(this.getModel(),user);
        Department department = this.departmentService.getDepartmentById(this.did);
        user.setDepartment(department);
        Set<Post> posts = this.postService.getPostsByPids(this.pids);
        user.setPosts(posts);
        this.userService.saveUser(user);
        return action2action;
    }
    public String checkUsername(){
        User user = this.userService.getUserByName(this.getModel().getUsername());
        if(user==null){
           this.message = "该用户名可以使用";
        }else{
            this.message = "该用户名不可以使用";
        }
        return SUCCESS;
    }
}
