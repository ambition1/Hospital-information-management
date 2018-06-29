package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: recipe数据库操作接口
 * @Date: Created in 22:45 2018/6/16
 */
public interface RecipeDao extends JpaRepository<recipe, Integer> {

    /**
     * 为处方添加检查项
     * @param userid
     * @param checkid
     */
    @Modifying
    @Query(value = "update recipe set checkid = ?2 where userid = ?1", nativeQuery = true)
    void addRecipeCheckid(Integer userid, Integer checkid);

    /**
     * 为username患者添加处方信息
     * @param context
     * @param userid
     */
    @Modifying
    @Query(value = "UPDATE recipe SET recipecontext=?1 WHERE userid=?2", nativeQuery = true)
    void addRecipe(String context, Integer userid);

    /**
     * 查询username患者的处方编号
     * @param userid
     * @return
     */
    @Query(value = "select recipeid from recipe where userid=?1", nativeQuery = true)
    Integer findRecipeid(Integer userid);

}
