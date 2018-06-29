package com.coursedesign.sql.service.Bill;

import com.coursedesign.sql.entity.personbill;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Bill
 * @Description: 账单接口
 * @Date: Created in 19:12 2018/6/22
 */
public interface BillService {

    /**
     * 展示所有患者
     * @param page
     * @param limit
     * @return
     */
    List<personbill> findAllPerson(Integer page, Integer limit);

    /**
     * 总条数
     * @return
     */
    Integer findAllPersonCount();

    /**
     * 查询指定用户
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<personbill> searchPersonBill(String username, Integer page, Integer limit);

    /**
     * 指定用户条数
     * @param username
     * @return
     */
    Integer searchPersonBill(String username);

    /**
     * 查询指定用户检查项金额
     * @param userid
     * @return
     */
    Double searchCheckMoney(Integer userid);

}
