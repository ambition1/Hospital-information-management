package com.coursedesign.sql.service.Recipe.impl;

import com.coursedesign.sql.dao.BillDao;
import com.coursedesign.sql.dao.PersonDao;
import com.coursedesign.sql.dao.PersonRecipeDao;
import com.coursedesign.sql.dao.RecipeDao;
import com.coursedesign.sql.entity.personrecipe;
import com.coursedesign.sql.service.Recipe.RecipeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Recipe.impl
 * @Description: 添加处方接口实现类
 * @Date: Created in 19:22 2018/6/21
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Resource
    private RecipeDao recipeDao;
    @Resource
    private PersonRecipeDao personRecipeDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private BillDao billDao;

    /**
     * 所有患者处方信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<personrecipe> recipeListView(Integer page, Integer limit) {
        return personRecipeDao.findAllRecipeView((page-1)*limit, limit);
    }

    /**
     * 返回总条数
     * @return
     */
    @Override
    public Integer recipeListViewCount() {
        return personRecipeDao.findAllRecipeViewCount();
    }

    /**
     * 模糊搜索患者
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<personrecipe> searchRecipeListView(String username, Integer page, Integer limit) {
        return personRecipeDao.searchRecipeView(username, (page-1)*limit, limit);
    }

    /**
     * 模糊查询条数
     * @param username
     * @return
     */
    @Override
    public Integer searchRecipeListViewCount(String username) {
        return personRecipeDao.searchRecipeViewCount(username);
    }

    /**
     * 添加处方信息
     * @param context
     * @param userid
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addRecipe(String context, Integer userid) {

        recipeDao.addRecipe(context, userid);

        billDao.addRecipe(userid, recipeDao.findRecipeid(userid));

        billDao.updataMoney(userid, 50.00);
    }
}
