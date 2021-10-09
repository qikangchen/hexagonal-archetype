package com.github.qikangchen.archetype.application.service;

import com.github.qikangchen.archetype.application.port.in.Query;
import com.github.qikangchen.archetype.domain.Component;
import org.springframework.stereotype.Service;

@Service
public class QueryService implements Query {

    private final Component component;

    public QueryService(Component component){
        this.component = component;
    }

    @Override
    public String get() {
        return component.getData();
    }

}
