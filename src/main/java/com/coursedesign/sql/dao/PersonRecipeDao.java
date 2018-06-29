package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.personrecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: personrecipe数据库接口
 * @Date: Created in 18:23 2018/6/21
 */

public interface PersonRecipeDao extends JpaRepository<personrecipe, Integer> {

    /**
     * 展示所有view中数据
     * @param page
     * @param limit
     * @return
     */
    @Query(value = "select * from personrecipe limit ?1, ?2", nativeQuery = true)
    List<personrecipe> findAllRecipeView(Integer page, Integer limit);

    /**
     * 查询所有条数
     * @return
     */
    @Query(value = "select count(*) from personrecipe", nativeQuery = true)
    Integer findAllRecipeViewCount();

    /**
     * 搜索指定患者，支持模糊
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @Query(value = "select * from personrecipe where username like %?1% limit ?2, ?3", nativeQuery = true)
    List<personrecipe> searchRecipeView(String username, Integer page, Integer limit);

    /**
     * 模糊查询条数
     * @param username
     * @return
     */
    @Query(value = "select count(*) from personrecipe where username like %?1%", nativeQuery = true)
    Integer searchRecipeViewCount(String username);

}
