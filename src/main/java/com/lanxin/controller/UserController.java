package com.lanxin.controller;

import com.lanxin.ov.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequiresRoles("admin")
    @RequestMapping("/select")
    public ResponseData select(){
        SecurityUtils.getSubject().checkRoles();
        return new ResponseData("200","查询成功");
    }

    @RequiresPermissions("lyp:delete")
    @RequestMapping("/delete")
    public ResponseData delete(){
        return new ResponseData("200","删除成功");
    }
}
