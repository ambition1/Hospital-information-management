package com.coursedesign.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description:
 * @Date: Created in 18:35 2018/6/22
 */

@Entity
@Table(name = "personbill")
public class personbill {

    @Id
    @Column(length = 10)
    private Integer userid;
    @Column(length = 20)
    private String username;
    @Column(length = 5)
    private String usersex;
    @Column(length = 10)
    private Integer userage;
    @Column(length = 15)
    private String userphone;
    @Column(length = 10)
    private Double money;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
