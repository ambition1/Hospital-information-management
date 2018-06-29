package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.intime;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: intime数据库操作接口
 * @Date: Created in 22:42 2018/6/16
 */
public interface IntimeDao extends JpaRepository<intime, String> {



}
