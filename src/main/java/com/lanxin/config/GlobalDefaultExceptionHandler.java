package com.lanxin.config;

import com.lanxin.ov.ResponseData;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler(HttpServletRequest request,Exception e){
        return new ResponseData("500","未授权");
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler1(HttpServletRequest request,Exception e){
        return new ResponseData("500","密码错误");
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler2(HttpServletRequest request,Exception e){
        return new ResponseData("500","用户不存在");
    }
}
