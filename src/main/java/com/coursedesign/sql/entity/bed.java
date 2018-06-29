package com.coursedesign.sql.entity;

import javax.persistence.*;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: bed持久层
 * @Date: Created in 16:33 2018/6/15
 */

@Entity
@Table(name = "bed")
public class bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedid;
    @Column(length = 20)
    private String username;
    @Column(length = 5)
    private String isempty;

    public Integer getBedid() {
        return bedid;
    }

    public void setBedid(Integer bedid) {
        this.bedid = bedid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsempty() {
        return isempty;
    }

    public void setIsempty(String isempty) {
        this.isempty = isempty;
    }
}
