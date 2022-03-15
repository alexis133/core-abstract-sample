package com.example.demo.controller;

import com.example.demo.dto.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void patchStock(@Valid @RequestBody ShoeV3 shoe) {
        stockService.patchStock(shoe);
    }

    @PatchMapping
    public void patchStocks(@Valid @RequestBody List<ShoeV3> shoes) {
        stockService.patchStocks(shoes);
    }
}
