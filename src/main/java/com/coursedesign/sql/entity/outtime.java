package com.coursedesign.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: outtime持久层
 * @Date: Created in 22:33 2018/6/16
 */

@Entity
@Table(name = "outtime")
public class outtime {

    @Id
    private String outhospital;
    @Column(length = 10)
    private Integer userid;
    @Column(length = 10)
    private Integer recipeid;
    @Column(length = 10)
    private Integer billid;
    @Column(length = 10)
    private Integer doctorid;

    public String getOuthospital() {
        return outhospital;
    }

    public void setOuthospital(String outhospital) {
        this.outhospital = outhospital;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Integer recipeid) {
        this.recipeid = recipeid;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }
}
