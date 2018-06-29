package com.coursedesign.sql.service.Login.impl;

import com.coursedesign.sql.dao.LoginDao;
import com.coursedesign.sql.entity.login;
import com.coursedesign.sql.service.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Login.impl
 * @Description: 登录接口实现
 * @Date: Created in 20:26 2018/6/28
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 登录检查
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean checkLogin(String username, String password) {
        return loginDao.existsByUsernameAndPassword(username, password);
    }

    /**
     * 注册接口
     *
     * @param username
     * @param password
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addUser(String username, String password) {

        login msg = new login();
        msg.setId(null);
        msg.setUsername(username);
        msg.setPassword(password);
        loginDao.save(msg);

    }


}
