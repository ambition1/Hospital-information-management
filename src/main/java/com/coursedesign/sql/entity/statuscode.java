package com.coursedesign.sql.entity;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

/**
 * @Author: yang
 * @ProjectName: sql
 * @Package: com.coursedesign.sql.entity
 * @Description: 返回状态实体类
 * @Date: Created in 20:10 2018/6/15
 */

public class statuscode {

    private String code;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
