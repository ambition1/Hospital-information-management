package com.coursedesign.sql.entity;

import javax.persistence.*;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: recipe持久层
 * @Date: Created in 22:36 2018/6/16
 */

@Entity
@Table(name = "recipe")
public class recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeid;
    @Column(length = 10)
    private String recipecontext;
    @Column(length = 10)
    private Integer doctorid;
    @Column(length = 10)
    private Integer userid;
    @Column(length = 10)
    private Integer checkid;

    public Integer getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Integer recipeid) {
        this.recipeid = recipeid;
    }

    public String getRecipecontext() {
        return recipecontext;
    }

    public void setRecipecontext(String recipecontext) {
        this.recipecontext = recipecontext;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }
}
