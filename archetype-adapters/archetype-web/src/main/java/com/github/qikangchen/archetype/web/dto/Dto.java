package com.github.qikangchen.archetype.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Dto {

    private String value;

    // Need empty constructor for json marshalling
    public Dto(){

    }

    public Dto(String value){
        this.value = value;
    }

}
