package com.coursedesign.sql.entity;

import javax.persistence.*;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: intame持久层
 * @Date: Created in 22:30 2018/6/16
 */

@Entity
@Table(name = "intime")
public class intime {

    @Id
    private String inhospital;
    @Column(length = 20)
    private String username;
    @Column(length = 10)
    private Integer bedid;


    public String getInhospital() {
        return inhospital;
    }

    public void setInhospital(String inhospital) {
        this.inhospital = inhospital;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBedid() {
        return bedid;
    }

    public void setBedid(Integer bedid) {
        this.bedid = bedid;
    }

}
