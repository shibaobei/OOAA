package com.oa.action;

import com.oa.entity.Menuitem;
import com.oa.entity.User;
import com.oa.service.MenuitemService;
import com.oa.service.PrivilegeService;
import com.oa.service.UserService;
import com.oa.utils.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-18.
 */
@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Menuitem>{
    @Resource(name="privilegeService")
    private PrivilegeService privilegeService;
    @Resource(name="userService")
    private UserService userService;
    @Resource(name="menuitemService")
    private MenuitemService menuitemService;

    private Long uid;
    private String mids;
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getMids() {
        return mids;
    }
    public void setMids(String mids) {
        this.mids = mids;
    }

    private Collection<Menuitem> privileges;
    public Collection<Menuitem> getPrivileges() {
        return privileges;
    }

    private Collection<Menuitem> checkedNodes;
    public Collection<Menuitem> getCheckedNodes() {
        return checkedNodes;
    }

    public String showPrivilege(){
        this.privileges = this.privilegeService.getPrivileges(this.uid);
        return SUCCESS;
    }

    /**
     *保存某一个用户的权限
     */
    public String savePrivilege(){
        System.out.print(checkedNodes);
        User user = this.userService.getUserById(uid);
        Set<Menuitem> menuitems = this.menuitemService.getMenuitemByIDS(StringUtil.String2Longs(mids));
        user.setMenuitems(menuitems);
        this.userService.updateUser(user);
        return SUCCESS;
    }
}
