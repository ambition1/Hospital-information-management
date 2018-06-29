package com.coursedesign.sql.dao;

import com.coursedesign.sql.entity.bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.dao
 * @Description: Bed数据库操作层
 * @Date: Created in 17:11 2018/6/15
 */
public interface BedDao extends JpaRepository<bed, Integer> {

    @Query(value = "select * from bed where isempty = '空'", nativeQuery = true)
    List<bed> findEmpty();

}
