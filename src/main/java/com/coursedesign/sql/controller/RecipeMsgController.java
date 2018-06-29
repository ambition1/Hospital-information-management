package com.coursedesign.sql.controller;

import com.coursedesign.sql.entity.statuscode;
import com.coursedesign.sql.service.Recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.controller
 * @Description:
 * @Date: Created in 20:04 2018/6/21
 */
@Controller
@RequestMapping(value = "/recipe")
public class RecipeMsgController {

    @Resource
    private RecipeService recipeService;

    @RequestMapping(value = "/recipe")
    public ModelAndView recipe(){
        return new ModelAndView("recipe");
    }

    /**
     * 展示所有患者处方
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/recipelist")
    @ResponseBody
    public Map<String, Object> recipeViewList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count", recipeService.recipeListViewCount());
        map.put("data", recipeService.recipeListView(page, limit));

        return map;
    }

    /**
     *模糊搜索患者
     * @param uername
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/searchrecipe")
    @ResponseBody
    public Map<String, Object> searchRecipeView(@RequestParam(value = "username") String uername,
                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit){

        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count", recipeService.searchRecipeListViewCount(uername));
        map.put("data", recipeService.searchRecipeListView(uername, page, limit));

        return map;
    }

    @RequestMapping(value = "/addrecipe")
    @ResponseBody
    public statuscode addRecipe(@RequestParam(value = "context") String context,
                                @RequestParam(value = "userid") Integer userid){
        statuscode code = new statuscode();
        try {

            System.out.println(context +"                  " + userid);

            recipeService.addRecipe(context, userid);
            code.setCode("20000");
            code.setStatus("执行成功！");
            return code;
        } catch (Exception e) {
            code.setCode("20001");
            code.setStatus("执行失败！");
            return code;
        }
    }

}
