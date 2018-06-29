package com.coursedesign.sql.entity;

import javax.persistence.*;


/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: check持久层
 * @Date: Created in 22:28 2018/6/16
 */
@Entity
@Table(name = "inspect")
public class inspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkid;
    @Column(length = 20)
    private String checkname;
    @Column(length = 10)
    private Double money;

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public String getCheckname() {
        return checkname;
    }

    public void setCheckname(String checkname) {
        this.checkname = checkname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
