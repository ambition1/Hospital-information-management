package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.inspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: check数据库操作接口
 * @Date: Created in 22:41 2018/6/16
 */
public interface CheckDao extends JpaRepository<inspect, Integer> {

    /**
     * 查询金额
     * @param checkid
     * @return
     */
    @Query(value = "select money from inspect where checkid=?1", nativeQuery = true)
    Double findMoney(Integer checkid);

}
