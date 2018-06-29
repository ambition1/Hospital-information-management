package com.coursedesign.sql.service.Check.impl;

import com.coursedesign.sql.dao.*;
import com.coursedesign.sql.entity.inspect;
import com.coursedesign.sql.entity.personcheck;
import com.coursedesign.sql.service.Check.CheckMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.service.Check.impl
 * @Description:
 * @Date: Created in 21:25 2018/6/17
 */
@Service
public class CheckMsgImpl implements CheckMsgService {

    @Resource
    private PersonDao personDao;
    @Resource
    private CheckDao checkDao;
    @Resource
    private PersonCheckDao personCheckDao;
    @Resource
    private IntimeDao intimeDao;
    @Resource
    private RecipeDao recipeDao;
    @Resource
    private BillDao billDao;

    /**
     * 添加检查项
     * @param userid
     * @param checkid
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addCheck(Integer userid, Integer checkid, String username) {

        personDao.addCheck(userid, checkid);

        recipeDao.addRecipeCheckid(userid, checkid);

        billDao.addCheckid(userid, checkid);

        billDao.updataMoney(userid, checkDao.findMoney(checkid));
    }

    /**
     * 展示所有患者
     * @param num
     * @param limit
     * @return
     */
    @Override
    public List<personcheck> showList(Integer num, Integer limit) {

        return personCheckDao.findAllView((num - 1)*limit, limit);
    }

    /**
     * 查询所有用户条数
     * @return
     */
    @Override
    public Integer showListNum() {
        return personCheckDao.findAllViewCount();
    }

    /**
     * 所有检查项
     * @return
     */
    @Override
    public List<inspect> findall() {
        return checkDao.findAll();
    }

    /**
     * 查询指定患者
     * @param username
     * @return
     */
    @Override
    public List<personcheck> searchPerson(String username, Integer page, Integer limit) {
        return personCheckDao.searchView(username, (page-1)*limit, limit);
    }

    /**
     * 查询对应username的患者的条数
     * @param username
     * @return
     */
    @Override
    public Integer searchPearsonNum(String username) {
        return personCheckDao.searchViewCount(username);
    }


}
