package com.coursedesign.sql.service.OutHospital.impl;

import com.coursedesign.sql.dao.BillDao;
import com.coursedesign.sql.dao.OuttimeDao;
import com.coursedesign.sql.dao.PersonDao;
import com.coursedesign.sql.dao.RecipeDao;
import com.coursedesign.sql.entity.outtime;
import com.coursedesign.sql.entity.person;
import com.coursedesign.sql.service.OutHospital.OutHospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.OutHospital.impl
 * @Description: 出院实现
 * @Date: Created in 21:16 2018/6/22
 */

@Service
public class OutHospitalImpl implements OutHospitalService {

    @Resource
    private PersonDao personDao;
    @Resource
    private BillDao billDao;
    @Resource
    private RecipeDao recipeDao;
    @Resource
    private OuttimeDao outtimeDao;

    /**
     * 展示所有患者
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<person> findAllUser(Integer page, Integer limit) {
        return personDao.userlist((page-1)*limit, limit);
    }

    /**
     * 所有患者条数
     * @return
     */
    @Override
    public Integer findAllUserCount() {
        return personDao.userListNum();
    }

    /**
     * 模糊查询
     * @param username
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<person> searchUser(String username, Integer page, Integer limit) {
        return personDao.searchUserList(username, (page-1)*limit, limit);
    }

    /**
     * 模糊查询条数
     * @param username
     * @return
     */
    @Override
    public Integer searchUserCount(String username) {
        return personDao.serarchUserListCount(username);
    }

    /**
     * 获取金额
     * @param userid
     * @return
     */
    @Override
    public Double getMoney(Integer userid) {
        return billDao.getMoney(userid);
    }

    /**
     * 出院
     * @param money
     * @param date
     * @param userid
     * @param doctorid
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void personOut(Double money, String date, Integer userid, Integer doctorid) {

        personDao.updataMoney(userid, money);
        personDao.updataOutDate(userid, date);

        outtime out = new outtime();
        out.setOuthospital(date);
        out.setUserid(userid);
        out.setRecipeid(recipeDao.findRecipeid(userid));
        out.setBillid(billDao.searchBillId(userid));
        out.setDoctorid(doctorid);

        outtimeDao.save(out);

    }
}
