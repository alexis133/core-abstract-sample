package com.example.demo.controller;

import com.example.demo.dto.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.exception.NoSuchShoeException;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

  private final StockService stockService;

  @GetMapping("/stocks")
  public Stock stocks(@RequestParam(defaultValue = "3") Integer version) {
    return stockService.stocks(version);
  }

  @PatchMapping("/stock")
  public void patchStock(@RequestBody ShoeV3 shoe) throws NoSuchShoeException {
    stockService.patchStock(shoe);
  }

  @PatchMapping("/stocks")
  public void patchStocks(@RequestBody List<ShoeV3> shoes) throws NoSuchShoeException {
    stockService.patchStocks(shoes);
  }
}
