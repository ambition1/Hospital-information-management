package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: person数据库操作接口
 * @Date: Created in 22:39 2018/6/16
 */
public interface PersonDao extends JpaRepository<person, Integer> {

    /**
     * 添加检查项
     * @param userid
     * @param checkid
     */
    @Modifying
    @Query(value = "update person set checkid=?2 where userid=?1", nativeQuery = true)
    void addCheck(Integer userid, Integer checkid);

    /**
     * 分页显示所有患者
     * @param pageNum
     * @param pageLimit
     * @return
     */
    @Query(value = "select * from person limit ?1, ?2", nativeQuery = true)
    List<person> userlist(Integer pageNum, Integer pageLimit);

    /**
     * 所有患者条数
     * @return
     */
    @Query(value = "select count(*) from person ", nativeQuery = true)
    Integer userListNum();

    /**
     * 模糊查询患者
     * @param username
     * @param pageNum
     * @param pageLimit
     * @return
     */
    @Query(value = "select * from person where username like %?1% limit ?2, ?3", nativeQuery = true)
    List<person> searchUserList(String username, Integer pageNum, Integer pageLimit);

    /**
     * 模糊查询条数
     * @param username
     * @return
     */
    @Query(value = "select count(*) from person where username like %?1%", nativeQuery = true)
    Integer serarchUserListCount(String username);

    /**
     * 查询对应用户的医生id
     * @param userid
     * @return
     */
    @Query(value = "select doctorid from person where userid = ?1", nativeQuery = true)
    Integer findDoctorid(Integer userid);

    /**
     * 查询对应患者的检查项id
     * @param userid
     * @return
     */
    @Query(value = "select checkid from person where userid = ?1", nativeQuery = true)
    Integer findCheckid(Integer userid);

    /**
     * 查询用户id
     * @param username
     * @return
     */
    @Query(value = "select userid from person where username = ?1", nativeQuery = true)
    Integer findUserid(String username);

    /**
     * 写入实缴金额
     * @param userid
     * @param money
     */
    @Modifying
    @Query(value = "update person set money = ?2 where userid =?1", nativeQuery = true)
    void updataMoney(Integer userid, Double money);

    /**
     * 添加离院时间
     * @param userid
     * @param data
     */
    @Modifying
    @Query(value = "update person set outhospital = ?2 where userid = ?1", nativeQuery = true)
    void updataOutDate(Integer userid, String data);

}
