package com.cqtalk.util;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;


//全参构造
//无参构造



//@Getter
public enum Role {
    TYPE("1"),CONTESTS("contests:token");




    private String typeName;

    private Integer time;

    Role(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeName() {
        return typeName;
    }



}
