package com.example.demo.controller;

import com.example.demo.dto.out.IShoe;
import com.example.demo.dto.out.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public Stock stocks(@RequestParam(defaultValue = "3") Integer version) {
        return stockService.stocks(version);
    }

    @PatchMapping
    public void patchStocks(List<ShoeV3> shoes) {
        stockService.patchStocks(shoes);
    }
}
