package com.github.qikangchen.archetype.domain;

import lombok.Builder;

@org.springframework.stereotype.Component
public class Component {

    private String data;

    @Builder
    public Component(){
        //Init
    }

    public String getData(){
        return data;
    }

    public void editData(final String data) {
        this.data = data;
    }
}
