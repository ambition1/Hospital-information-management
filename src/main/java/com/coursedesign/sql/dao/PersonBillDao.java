package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.personbill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description:
 * @Date: Created in 18:37 2018/6/22
 */
public interface PersonBillDao extends JpaRepository<personbill, Integer> {

    /**
     * 查询所有用户账单
     * @param page
     * @param limit
     * @return
     */
    @Query(value = "select * from personbill limit ?1, ?2", nativeQuery = true)
    List<personbill> findAllPersonBill(Integer page, Integer limit);

    /**
     * 查询所有条数
     * @return
     */
    @Query(value = "select count(*) from personbill", nativeQuery = true)
    Integer findAllPersonBillCount();

    /**
     * 搜索患者
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @Query(value = "select * from personbill where username like %?1% limit ?2, ?3", nativeQuery = true)
    List<personbill> searchPersonBill(String username, Integer page, Integer limit);

    /**
     * 查询条数
     * @return
     */
    @Query(value = "select count(*) from personbill where username like %?1%", nativeQuery = true)
    Integer searchPersonBillCount(String username);

}
