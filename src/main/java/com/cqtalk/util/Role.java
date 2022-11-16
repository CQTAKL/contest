package com.cqtalk.util;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;


//全参构造
//无参构造



//@Getter
public enum Role {
    state1(1),CONTESTS("contests:token"),state0(0),state2(2);




    private String typeName;
    private int number;



    Role(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeName() {
        return typeName;
    }

    Role(int number) {
        this.number = number;
    }
    public int getnumber() {
        return number;
    }


}
