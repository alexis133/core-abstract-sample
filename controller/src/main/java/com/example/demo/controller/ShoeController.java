package com.example.demo.controller;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.Shoes;
import com.example.demo.facade.ShoeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/shoes")
@RequiredArgsConstructor
public class ShoeController {

    private final ShoeFacade shoeFacade;

    @GetMapping
    public ResponseEntity<Shoes> all(ShoeFilter filter, @RequestHeader(defaultValue = "3") Integer version) {

        return ResponseEntity.ok(shoeFacade.get(version).search(filter));

    }

}
