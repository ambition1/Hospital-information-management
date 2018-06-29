package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: bill数据库操作接口
 * @Date: Created in 22:40 2018/6/16
 */
public interface BillDao extends JpaRepository<bill, Integer> {

    /**
     * 为账单中添加对应用户的检查项
     * @param userid
     * @param checkid
     */
    @Modifying
    @Query(value = "update bill set checkid=?2 where userid=?1",nativeQuery = true)
    void addCheckid(Integer userid, Integer checkid);

    /**
     * 为账单中添加对应患者的处方单号
     * @param userid
     * @param recipeid
     */
    @Modifying
    @Query(value = "update bill set recipeid=?2 where userid=?1", nativeQuery = true)
    void addRecipe(Integer userid, Integer recipeid);

    /**
     * 更新金额
     * @param usrid
     * @param money
     */
    @Modifying
    @Query(value = "update bill set money=money+?2 where userid=?1", nativeQuery = true)
    void updataMoney(Integer usrid, Double money);

    /**
     * 获取金额
     * @param userid
     * @return
     */
    @Query(value = "select money from bill where userid = ?1", nativeQuery = true)
    Double getMoney(Integer userid);

    /**
     * 获取患者账单id
     * @param userid
     * @return
     */
    @Query(value = "select billid from bill where userid = ?1", nativeQuery = true)
    Integer searchBillId(Integer userid);

}
