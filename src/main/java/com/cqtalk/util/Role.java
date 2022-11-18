package com.cqtalk.util;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;


//全参构造
//无参构造



//@Getter
public enum Role {
    state1(1,"已删除"),
    state0(0,"未删除"),
    state2(2,"审核中"),
    levelNameA(1,"国家级"),
    levelNameB(2,"省级"),
    levelNameC(3,"院级");





    public final Integer status;
    public final String msg;

    Role(Integer status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public static String getMsgByKey(Integer status) {
        for (Role type : Role.values()) {
            if (type.getStatus() == status) {
                return type.msg;
            }
        }
        return null;
    }

}
