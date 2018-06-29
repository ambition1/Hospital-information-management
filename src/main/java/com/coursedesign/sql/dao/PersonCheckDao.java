package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.personcheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: 用户检查视图映射接口
 * @Date: Created in 19:29 2018/6/20
 */
public interface PersonCheckDao extends JpaRepository<personcheck, Integer> {

    /**
     * 查询视图中数据条数
     * @param page
     * @param limit
     * @return
     */
    @Query(value = "select * from personcheck limit ?1,?2", nativeQuery = true)
    List<personcheck> findAllView(Integer page, Integer limit);

    /**
     * 查询视图中所有数据条数
     * @return
     */
    @Query(value = "select count(*) from personcheck", nativeQuery = true)
    Integer findAllViewCount();

    /**
     * 查询指定的患者
     * @param username
     * @return
     */
    @Query(value = "select * from personcheck where username like %?1% limit ?2, ?3", nativeQuery = true)
    List<personcheck> searchView(String username, Integer page, Integer limit);

    /**
     * 查询对应username的用户的条数
     * @param username
     * @return
     */
    @Query(value = "select count(*) from personcheck where username like %?1%", nativeQuery = true)
    Integer searchViewCount(String username);
}
