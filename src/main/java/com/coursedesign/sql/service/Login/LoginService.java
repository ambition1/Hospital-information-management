package com.coursedesign.sql.service.Login;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Login
 * @Description: 登录接口
 * @Date: Created in 20:24 2018/6/28
 */
public interface LoginService {

    /**
     * 登录检验接口
     * @param username
     * @param password
     * @return
     */
    boolean checkLogin(String username, String password);

    /**
     * 注册接口
     * @param username
     * @param password
     */
    void addUser(String username, String password);

}
