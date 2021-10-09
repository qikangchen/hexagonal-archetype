package com.github.qikangchen.archetype;

import com.github.qikangchen.archetype.web.dto.Dto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemTest {

    @LocalServerPort
    private int port;

    @Test
    void test(){

        Dto incomingDto = new Dto("someValue");

        Dto outDto = given()
            .port(port)
            .body(incomingDto)
            .contentType(ContentType.JSON)
        .when()
            .post("/controller/1/set")
        .then()
            .statusCode(HttpStatus.ACCEPTED.value())
        .extract()
            .body()
            .as(Dto.class);

        assertThat(outDto.getValue(), equalTo("someValue"));
    }

}
