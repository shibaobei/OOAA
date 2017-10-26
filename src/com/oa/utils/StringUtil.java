package com.oa.utils;

import com.oa.entity.User;
import org.apache.struts2.ServletActionContext;

/**
 * Created by Administrator on 2017-10-18.
 */
public class StringUtil {
    public static Long[] String2Longs(String ids){
        String[] s = ids.split(",");
        Long[ ] aa = new Long[s.length];
        int index = 0;
        for(String string:s){
            aa[index] = Long.valueOf(string);
            index++;
        }
        return aa;
    }
    public static User fromSession(){
        return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
    }

    public static void putUser2Session(User user){
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
    }
}
