package com.coursedesign.sql.controller;

import com.coursedesign.sql.service.Login.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.controller
 * @Description: 登录
 * @Date: Created in 17:40 2018/6/28
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    /**
     * 登录判断
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView checkLogin(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password){

        String pass = DigestUtils.md5Hex(username + password + "sql");

        if (loginService.checkLogin(username, pass)){
            return new ModelAndView("index");
        }
        return new ModelAndView("login");
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView registerDo(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password){

        String pass = DigestUtils.md5Hex(username + password + "sql");

        try {
            loginService.addUser(username, pass);
            return new ModelAndView("login");
        } catch (Exception e) {
            return new ModelAndView("tip");
        }
    }

}
