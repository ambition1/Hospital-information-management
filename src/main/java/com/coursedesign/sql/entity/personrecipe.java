package com.coursedesign.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: personrecipe 视图映射实体类
 * @Date: Created in 18:20 2018/6/21
 */

@Entity
@Table(name = "personrecipe")
public class personrecipe {

    @Id
    @Column(length = 10)
    private Integer userid;
    @Column(length = 20)
    private String username;
    @Column(length = 5)
    private String usersex;
    @Column(length = 10)
    private Integer userage;
    @Column(length = 20)
    private String useraddress;
    @Column(length = 15)
    private String userphone;
    @Column(length = 10)
    private Integer bedid;
    @Column(length = 10)
    private Integer doctorid;
    @Column(length = 10)
    private Integer checkid;
    @Column(length = 10)
    private Double money;
    @Column(length = 20)
    private String inhospital;
    @Column(length = 20)
    private String outhospital;
    @Column(length = 50)
    private String recipecontext;

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

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Integer getBedid() {
        return bedid;
    }

    public void setBedid(Integer bedid) {
        this.bedid = bedid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
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

    public String getInhospital() {
        return inhospital;
    }

    public void setInhospital(String inhospital) {
        this.inhospital = inhospital;
    }

    public String getOuthospital() {
        return outhospital;
    }

    public void setOuthospital(String outhospital) {
        this.outhospital = outhospital;
    }

    public String getRecipecontext() {
        return recipecontext;
    }

    public void setRecipecontext(String recipecontext) {
        this.recipecontext = recipecontext;
    }
}
