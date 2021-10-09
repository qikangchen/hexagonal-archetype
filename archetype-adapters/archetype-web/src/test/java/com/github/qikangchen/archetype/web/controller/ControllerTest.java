package com.github.qikangchen.archetype.web.controller;

import com.github.qikangchen.archetype.application.port.in.Query;
import com.github.qikangchen.archetype.application.port.in.UseCase;
import com.github.qikangchen.archetype.web.dto.Dto;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = Controller.class)
class ControllerTest {

    private static final int TEST_ID = 42;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private Query query;
    @MockBean
    private UseCase useCase;

    @BeforeEach
    void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void testSet(){
        when(query.get()).thenReturn("someValue");

        Dto incomingDto = new Dto("someValueForIncomingValue");

        Dto responseDto = given()
            .contentType(ContentType.JSON)
            .body(incomingDto)
        .when()
            .post("controller/" + TEST_ID + "/set")
        .then()
            .status(HttpStatus.ACCEPTED)
            .contentType(ContentType.JSON)
        .extract()
            .as(Dto.class);

        assertThat(responseDto.getValue(), equalTo("someValue"));
    }

}