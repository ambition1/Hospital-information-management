package com.coursedesign.sql.entity;

import javax.persistence.*;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: 医生信息持久层
 * @Date: Created in 19:21 2018/6/15
 */
@Entity
@Table(name = "doctor")
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorid;
    @Column(length = 20)
    private String doctorname;
    @Column(length = 5)
    private String doctorsex;
    @Column(length = 20)
    private String doctorphone;

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctorsex() {
        return doctorsex;
    }

    public void setDoctorsex(String doctorsex) {
        this.doctorsex = doctorsex;
    }

    public String getDoctorphone() {
        return doctorphone;
    }

    public void setDoctorphone(String doctorphone) {
        this.doctorphone = doctorphone;
    }
}
