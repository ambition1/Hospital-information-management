package com.coursedesign.sql.service.UserMsgService;

import com.coursedesign.sql.entity.bed;
import com.coursedesign.sql.entity.doctor;
import com.coursedesign.sql.entity.person;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.UserMsgService
 * @Description: 用户信息service
 * @Date: Created in 19:26 2018/6/15
 */
public interface UserMsg {

    /**
     * 查询所有空床位
     * @return
     */
    List<bed> findEmpty();

    /**
     * 查询所有医生
     * @return
     */
    List<doctor> findAll();

    /**
     * 患者入院操作
     * @param username
     * @param usersex
     * @param userage
     * @param userphone
     * @param useraddress
     * @param doctorid
     * @param bedid
     * @param date
     */
    void adduser(String username, String usersex, Integer userage,
                 String userphone, String useraddress, Integer doctorid,
                 Integer bedid, String date);

}
