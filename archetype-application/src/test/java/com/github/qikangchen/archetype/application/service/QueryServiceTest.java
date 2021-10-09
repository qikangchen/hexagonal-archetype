package com.github.qikangchen.archetype.application.service;

import com.github.qikangchen.archetype.application.port.in.Query;
import com.github.qikangchen.archetype.domain.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class QueryServiceTest {

    Component component;
    Query queryService;

    @BeforeEach
    void setup(){
        component = new Component();
        queryService = new QueryService(component);
    }

    @Test
    void test(){
        component.editData("DummyData");
        assertThat(queryService.get(), equalTo("DummyData"));
    }

}