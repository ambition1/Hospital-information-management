package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: 医生信息数据库操作
 * @Date: Created in 19:24 2018/6/15
 */
public interface DoctorDao extends JpaRepository<doctor, Integer> {

}
