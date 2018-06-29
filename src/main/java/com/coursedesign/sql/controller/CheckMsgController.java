package com.coursedesign.sql.controller;

import com.coursedesign.sql.entity.inspect;
import com.coursedesign.sql.entity.statuscode;
import com.coursedesign.sql.service.Check.CheckMsgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.controller
 * @Description: 检查信息页面
 * @Date: Created in 21:20 2018/6/17
 */
@Controller
@RequestMapping(value = "/check")
public class CheckMsgController {

    @Resource
    private CheckMsgService checkMsgService;

    @RequestMapping(value = "/check")
    public ModelAndView check(){
        return new ModelAndView("check");
    }

    /**
     * 展示所有患者
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/userlist")
    @ResponseBody
    public Map<String, Object> userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> list = new HashMap<>();

        list.put("code", 0);
        list.put("msg", "");
        list.put("count", checkMsgService.showListNum());
        list.put("data", checkMsgService.showList(page, limit));

        return list;
    }

    /**
     * 所有检查项
     * @return
     */
    @RequestMapping(value = "/allcheck")
    @ResponseBody
    public List<inspect> allCheck(){
        return checkMsgService.findall();
    }

    /**
     * 为患者添加检查项
     * @param userid
     * @param checkid
     * @return
     */
    @RequestMapping(value = "/addcheckforperson")
    @ResponseBody
    public statuscode addCheckForPerson(@RequestParam(value = "username") String username, @RequestParam(value = "userid") Integer userid,
                                        @RequestParam(value = "checkid") Integer checkid){

        statuscode code = new statuscode();

        try {
            checkMsgService.addCheck(userid, checkid, username);
            code.setCode("800000");
            code.setStatus("操作成功！");
            return code;
        } catch (Exception e) {
            code.setCode("800001");
            code.setStatus("操作失败！");
            return code;
        }
    }

    /**
     * 模糊搜索患者
     * @param username
     * @return
     */
    @RequestMapping(value = "/searchperson")
    @ResponseBody
    public Map<String, Object> searchPerson(@RequestParam(value = "username") String username,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", checkMsgService.searchPearsonNum(username));
        map.put("data", checkMsgService.searchPerson(username, page, limit));

        return map;

    }


}
