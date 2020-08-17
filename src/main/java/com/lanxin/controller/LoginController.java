package com.lanxin.controller;

import com.lanxin.ov.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    //登录
    @RequestMapping("/login")
    public ResponseData login(String username,String password){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        SecurityUtils.getSubject().login(token);
        ResponseData responseData = new ResponseData("200","登录成功");
        return responseData;
    }

    //退出登录
    @RequestMapping("/logout")
    public ResponseData logout() {
        SecurityUtils.getSubject().logout();
        ResponseData rb = new ResponseData("200", "退出成功");
        return rb;
    }

    //未登录
    @RequestMapping("/unLogin")
    public ResponseData unLogin() {
        return new ResponseData("401", "未登录");
    }
}
