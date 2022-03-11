package com.example.demo.controller;

import com.example.demo.dto.out.Stock;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public Stock stocks() {
        return stockService.stocks();
    }

    @PatchMapping
    public void patchStocks() {

    }
}
