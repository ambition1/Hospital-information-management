package com.coursedesign.sql.service.Check;

import com.coursedesign.sql.entity.inspect;
import com.coursedesign.sql.entity.person;
import com.coursedesign.sql.entity.personcheck;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Check
 * @Description: 添加检查项目接口
 * @Date: Created in 21:23 2018/6/17
 */
public interface CheckMsgService {

    /**
     * 添加检查项目
     * @param userid
     * @param checkid
     */
    void addCheck(Integer userid, Integer checkid, String username);

    /**
     * 展示说有患者
     * @param num
     * @param limit
     * @return
     */
    List<personcheck> showList(Integer num, Integer limit);

    /**
     * 查询所有画着条数
     * @return
     */
    Integer showListNum();

    /**
     * 查询所有检查
     * @return
     */
    List<inspect> findall();

    /**
     * 查询指定用户，支持模糊
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<personcheck> searchPerson(String username, Integer page, Integer limit);

    /**
     * 查询对应username的患者的条数
     * @param username
     * @return
     */
    Integer searchPearsonNum(String username);

}
