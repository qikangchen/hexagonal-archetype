package com.github.qikangchen.archetype.web.controller;

import com.github.qikangchen.archetype.application.port.in.Query;
import com.github.qikangchen.archetype.application.port.in.UseCase;
import com.github.qikangchen.archetype.web.dto.Dto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("controller/{id}")
public class Controller {

    private final Query query;
    private final UseCase useCase;

    public Controller(final Query query, final UseCase useCase){
        this.query = query;
        this.useCase = useCase;
    }

    @PostMapping(value = "set")
    public ResponseEntity<Dto> set(@PathVariable("id") final int id, @RequestBody final Dto dto){

        useCase.edit(dto.getValue());

        Dto responseDto = new Dto(query.get());
        return ResponseEntity.accepted().body(responseDto);
    }

}
