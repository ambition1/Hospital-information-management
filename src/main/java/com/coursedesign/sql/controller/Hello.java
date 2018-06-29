package com.coursedesign.sql.controller;

import com.coursedesign.sql.dao.*;
import com.coursedesign.sql.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.controller
 * @Description: 测试类
 * @Date: Created in 21:52 2018/6/14
 */
@Controller
public class Hello {

    @Resource
    private BedDao bedDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private DoctorDao doctorDao;
    @Resource
    private PersonCheckDao personCheckDao;
    @Resource
    private PersonRecipeDao personRecipeDao;
    @Resource
    private PersonBillDao personBillDao;
    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "/test")
    public ModelAndView show(){
        return new ModelAndView("tip");
    }

    @RequestMapping(value = "/test1")
    @ResponseBody
    public void show1(@RequestParam(value = "context") String userid, @RequestParam(value = "userid") Integer checkid){
        System.out.println(userid);
        System.out.println(checkid);
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public void test2(){

        System.out.println(loginDao.existsByUsernameAndPassword("123", ""));
    }

    @RequestMapping(value = "/test4")
    @ResponseBody
    public List<personbill> test4(){
        return personBillDao.findAllPersonBill(1,10);
    }

    @RequestMapping(value = "/test3")
    @ResponseBody
    public void test3(){
        person msg = new person();
        msg.setUserid(null);
        msg.setUsername("yx");
        msg.setUsersex("男");
        msg.setUserage(12);
        msg.setUseraddress("gjfdkv");
        msg.setUserphone("123456465");
        personDao.save(msg);
    }



}
