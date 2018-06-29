package com.coursedesign.sql.service.Bill.impl;

import com.coursedesign.sql.dao.CheckDao;
import com.coursedesign.sql.dao.PersonBillDao;
import com.coursedesign.sql.dao.PersonDao;
import com.coursedesign.sql.entity.personbill;
import com.coursedesign.sql.service.Bill.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Bill.impl
 * @Description:
 * @Date: Created in 19:16 2018/6/22
 */
@Service
public class BillServiceImpl implements BillService {

    @Resource
    private PersonBillDao personBillDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private CheckDao checkDao;

    /**
     * 展示所有患者账单
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<personbill> findAllPerson(Integer page, Integer limit) {
        return personBillDao.findAllPersonBill((page-1)*limit, limit);
    }

    /**
     * 所有用户账单
     * @return
     */
    @Override
    public Integer findAllPersonCount() {
        return personBillDao.findAllPersonBillCount();
    }

    /**
     * 查询患者 模糊搜索
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<personbill> searchPersonBill(String username, Integer page, Integer limit) {
        return personBillDao.searchPersonBill(username, (page-1)*limit, limit);
    }

    /**
     * 搜索用户条数
     * @param username
     * @return
     */
    @Override
    public Integer searchPersonBill(String username) {
        return personBillDao.searchPersonBillCount(username);
    }

    /**
     * 查询指定检查项金额
     * @param userid
     * @return
     */
    @Override
    public Double searchCheckMoney(Integer userid) {
        return checkDao.findMoney(personDao.findCheckid(userid));
    }
}
