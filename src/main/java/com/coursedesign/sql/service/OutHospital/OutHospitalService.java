package com.coursedesign.sql.service.OutHospital;

import com.coursedesign.sql.entity.person;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.OutHospital
 * @Description: 出院管理接口
 * @Date: Created in 21:11 2018/6/22
 */
public interface OutHospitalService {

    /**
     * 所有患者
     * @param page
     * @param limit
     * @return
     */
    List<person> findAllUser(Integer page, Integer limit);

    /**
     * 总条数
     * @return
     */
    Integer findAllUserCount();

    /**
     * 查询患者
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<person> searchUser(String username, Integer page, Integer limit);

    /**
     * 查询患者条数
     * @param username
     * @return
     */
    Integer searchUserCount(String username);

    /**
     * 获取金额
     * @param userid
     * @return
     */
    Double getMoney(Integer userid);

    /**
     * 出院
     * @param money
     * @param date
     * @param userid
     * @param doctorid
     */
    void personOut(Double money, String date, Integer userid, Integer doctorid);

}
