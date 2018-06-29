package com.coursedesign.sql.controller;

import com.coursedesign.sql.entity.bed;
import com.coursedesign.sql.entity.doctor;
import com.coursedesign.sql.entity.statuscode;
import com.coursedesign.sql.service.UserMsgService.UserMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.controller
 * @Description: 患者信息填写controller
 * @Date: Created in 16:09 2018/6/15
 */

@Controller
@RequestMapping(value = "/usermsg")
public class UserMsgController {

    @Resource
    private UserMsg userMsg;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    /**
     * 查询空床位
     * @return
     */
    @RequestMapping(value = "/findemptybed")
    @ResponseBody
    public List<bed> findEmpty(){
        return userMsg.findEmpty();
    }

    /**
     * 查询所有医师
     * @return
     */
    @RequestMapping(value = "/findalldoctor")
    @ResponseBody
    public List<doctor> findAllDoctor(){
        return userMsg.findAll();
    }

    /**
     * 患者入院
     * @param username
     * @param usersex
     * @param userage
     * @param userphone
     * @param useraddress
     * @param doctorid
     * @param bedid
     * @param inhospital
     * @return
     */
    @RequestMapping(value = "/adduser")
    @ResponseBody
    public statuscode addUser(@RequestParam(value = "username") String username, @RequestParam(value = "usersex") String usersex,
                              @RequestParam(value = "userage") Integer userage, @RequestParam(value = "userphone") String userphone,
                              @RequestParam(value = "useraddress") String useraddress, @RequestParam(value = "searchdoctorid") Integer doctorid,
                              @RequestParam(value = "searchbedid") Integer bedid, @RequestParam(value = "date") String inhospital){

        statuscode code = new statuscode();

        try {
            userMsg.adduser(username, usersex, userage, userphone, useraddress, doctorid, bedid, inhospital);
            code.setCode("200");
            code.setStatus("添加成功！");
            return code;
        } catch (Exception e) {
            code.setCode("400");
            code.setStatus("添加失败！");
            return code;
        }
    }

}
