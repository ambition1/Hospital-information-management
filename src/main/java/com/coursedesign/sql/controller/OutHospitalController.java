package com.coursedesign.sql.controller;

import com.coursedesign.sql.entity.statuscode;
import com.coursedesign.sql.service.OutHospital.OutHospitalService;
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
 * @Date: Created in 21:23 2018/6/22
 */
@Controller
@RequestMapping(value = "/out")
public class OutHospitalController {

    @Resource
    private OutHospitalService outHospitalService;

    @RequestMapping(value = "/out")
    public ModelAndView out(){
        return new ModelAndView("outhospital");
    }

    /**
     * 患者列表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/userlist")
    @ResponseBody
    public Map<String, Object> personlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", outHospitalService.findAllUserCount());
        map.put("data", outHospitalService.findAllUser(page, limit));
        return map;
    }

    /**
     * 查询患者列表
     *
     * 未显示查询结果，应该为表格未重载
     *
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/searchuser")
    @ResponseBody
    public Map<String, Object> searchPersonlist(@RequestParam(value = "username") String username,
                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> list = new HashMap<>();
        list.put("code", 0);
        list.put("msg", "");
        list.put("count", outHospitalService.searchUser(username, page, limit));
        list.put("data", outHospitalService.searchUserCount(username));
        return list;
    }

    /**
     * 获取金额
     * @param userid
     * @return
     */
    @RequestMapping(value = "/getmoney")
    @ResponseBody
    public Double getMoney(@RequestParam(value = "userid") Integer userid){
        return outHospitalService.getMoney(userid);
    }

    /**
     * 出院
     * @param money
     * @param date
     * @param userid
     * @param doctorid
     * @return
     */
    @RequestMapping(value = "/personout")
    @ResponseBody
    public statuscode outHospital(@RequestParam(value = "realmoney") Double money, @RequestParam(value = "date") String date,
                                  @RequestParam(value = "userid") Integer userid, @RequestParam(value = "doctorid") Integer doctorid){

        statuscode code = new statuscode();

        try {
            outHospitalService.personOut(money, date, userid, doctorid);
            code.setCode("800000");
            code.setStatus("操作成功");
            return code;
        } catch (Exception e) {
            code.setCode("800001");
            code.setStatus("操作成功");
            return code;
        }
    }

}
