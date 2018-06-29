package com.coursedesign.sql.service.UserMsgService.impl;

import com.coursedesign.sql.dao.*;
import com.coursedesign.sql.entity.*;
import com.coursedesign.sql.service.UserMsgService.UserMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.UserMsgService.impl
 * @Description: 用户信息Service实现类
 * @Date: Created in 19:28 2018/6/15
 */

@Service
public class UserMsgImpl implements UserMsg {

    @Resource
    private BedDao bedDao;
    @Resource
    private DoctorDao doctorDao;
    @Resource
    private IntimeDao intimeDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private RecipeDao recipeDao;
    @Resource
    private BillDao billDao;

    /**
     * 查询空床位
     * @return
     */
    @Override
    public List<bed> findEmpty() {
        return bedDao.findEmpty();
    }

    /**
     * 查询所有医生
     * @return
     */
    @Override
    public List<doctor> findAll() {
        return doctorDao.findAll();
    }

    /**
     * 用户入院
     * @param username
     * @param usersex
     * @param userage
     * @param userphone
     * @param useraddress
     * @param doctorid
     * @param bedid
     * @param date
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void adduser(String username, String usersex, Integer userage, String userphone, String useraddress, Integer doctorid, Integer bedid, String date) {
        /*
         添加床位信息
         */
        bed bedmsg = new bed();
        bedmsg.setBedid(bedid);
        bedmsg.setUsername(username);
        bedmsg.setIsempty("占");
        bedDao.save(bedmsg);

        /*
         添加住院信息
         */
        intime intimemsg = new intime();
        intimemsg.setInhospital(date);
        intimemsg.setUsername(username);
        intimemsg.setBedid(bedid);
        intimeDao.save(intimemsg);

        /*
         患者信息添加
         */
        person personmsg = new person();
        personmsg.setUserid(null);
        personmsg.setUsername(username);
        personmsg.setUserage(userage);
        personmsg.setUsersex(usersex);
        personmsg.setUseraddress(useraddress);
        personmsg.setUserphone(userphone);
        personmsg.setBedid(bedid);
        personmsg.setDoctorid(doctorid);
        personmsg.setInhospital(date);
        personmsg.setCheckid(0);
        personDao.save(personmsg);

        /*
         添加处方信息
         */
        recipe msg = new recipe();
        msg.setRecipeid(null);
        msg.setRecipecontext(null);
        msg.setDoctorid(doctorid);
        msg.setUserid(personDao.findUserid(username));
        msg.setCheckid(null);
        recipeDao.save(msg);

        /*
         添加账单信息
         */
        bill money = new bill();
        money.setBillid(null);
        money.setUserid(personDao.findUserid(username));
        money.setMoney(10.00);
        billDao.save(money);
    }


}
