package com.coursedesign.sql.controller;

import com.coursedesign.sql.service.Bill.BillService;
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
 * @Description: 账单详情
 * @Date: Created in 17:48 2018/6/22
 */
@Controller
@RequestMapping(value = "/bill")
public class BillMsgController {

    @Resource
    private BillService billService;

    @RequestMapping(value = "/bill")
    public ModelAndView bill(){
        return new ModelAndView("bill");
    }

    /**
     * 所有患者账单
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/personbilllist")
    @ResponseBody
    public Map<String, Object> personBillList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> list = new HashMap<>();
        list.put("code", 0);
        list.put("msg", "");
        list.put("count", billService.findAllPersonCount());
        list.put("data", billService.findAllPerson(page, limit));
        return list;
    }

    /**
     * 查询指定患者账单
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/searchpersonbill")
    @ResponseBody
    public Map<String, Object> searchPersonBill(@RequestParam(value = "username") String username,
                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", billService.searchPersonBill(username));
        map.put("data", billService.searchPersonBill(username, page, limit));
        return map;
    }

    /**
     * 查询金额
     * @param userid
     * @return
     */
    @RequestMapping(value = "/checkmoney")
    @ResponseBody
    public Double checkMoney(@RequestParam(value = "userid") Integer userid){
        return billService.searchCheckMoney(userid);
    }

}
