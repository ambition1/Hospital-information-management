package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.outtime;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: outtime数据库操作接口
 * @Date: Created in 22:44 2018/6/16
 */
public interface OuttimeDao extends JpaRepository<outtime, String> {
}
