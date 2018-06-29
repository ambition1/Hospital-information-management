package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: 登录查询接口
 * @Date: Created in 20:18 2018/6/28
 */
public interface LoginDao extends JpaRepository<login, Integer> {

    /**
     * 登录查询
     * @param username
     * @param password
     * @return
     */
    boolean existsByUsernameAndPassword(String username, String password);

}
