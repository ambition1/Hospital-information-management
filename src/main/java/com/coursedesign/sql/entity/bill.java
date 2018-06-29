package com.coursedesign.sql.entity;

import javax.persistence.*;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: bill持久层
 * @Date: Created in 22:25 2018/6/16
 */
@Entity
@Table(name = "bill")
public class bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billid;
    @Column(length = 10)
    private Integer userid;
    @Column(length = 10)
    private Integer recipeid;
    @Column(length = 10)
    private Integer checkid;
    @Column(length = 10)
    private Double money;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
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

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
