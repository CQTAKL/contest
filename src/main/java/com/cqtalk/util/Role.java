package com.cqtalk.util;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//全参构造
//无参构造



public enum Role {
    TYPE("1"),CONTESTS("contests");



    private String typeName;

    Role(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeName() {
        return typeName;
    }

}
