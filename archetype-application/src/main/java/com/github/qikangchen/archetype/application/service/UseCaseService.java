package com.github.qikangchen.archetype.application.service;

import com.github.qikangchen.archetype.application.port.in.UseCase;
import com.github.qikangchen.archetype.domain.Component;
import org.springframework.stereotype.Service;

@Service
public class UseCaseService implements UseCase {

    private final Component component;
    private String data;

    public UseCaseService(final Component component){
        this.component = component;
    }

    @Override
    public void edit(final String data) {
        component.editData(data);
    }

}
