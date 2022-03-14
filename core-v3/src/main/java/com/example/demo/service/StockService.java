package com.example.demo.service;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.facade.ShoeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

  private final ShoeFacade shoeFacade;
  private final ShoeService shoeService;

  public Stock stocks(Integer version) {
    return Stock.builder()
        .shoes(shoeFacade.get(version).search(new ShoeFilter(null, null)))
        .state(getState(shoeService.getTotalShoes()))
        .build();
  }

  private Stock.State getState(Integer total) {
    return switch (total) {
      case 0 -> Stock.State.EMPTY;
      case 30 -> Stock.State.FULL;
      default -> Stock.State.SOME;
    };
  }

  public void patchStocks(List<ShoeV3> shoes) {
    shoeService.updateShoes(shoes);
  }
}
