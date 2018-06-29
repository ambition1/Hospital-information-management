package com.coursedesign.sql.service.Recipe;

import com.coursedesign.sql.entity.personrecipe;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Recipe
 * @Description: 添加处方接口
 * @Date: Created in 19:12 2018/6/21
 */

public interface RecipeService {

    /**
     * 展示所有患者处方信息
     * @param page
     * @param limit
     * @return
     */
    List<personrecipe> recipeListView(Integer page, Integer limit);

    /**
     * 所有患者处方条数
     * @return
     */
    Integer recipeListViewCount();

    /**
     * 模糊查询患者处方信息
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<personrecipe> searchRecipeListView(String username, Integer page, Integer limit);

    /**
     * 模糊查询条数
     * @param username
     * @return
     */
    Integer searchRecipeListViewCount(String username);

    /**
     * 添加处方信息
     * @param context
     * @param userid
     */
    void addRecipe(String context, Integer userid);

}
