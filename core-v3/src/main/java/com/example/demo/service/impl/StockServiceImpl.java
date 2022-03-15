package com.example.demo.service.impl;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.facade.ShoeFacade;
import com.example.demo.service.ShoeService;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
  private final ShoeFacade shoeFacade;
  private final ShoeService shoeService;

  public Stock stocks(Integer version) {
    return Stock.builder()
        .shoes(shoeFacade.get(version).search(new ShoeFilter(null, null)))
        .state(getState(shoeService.getTotalShoes()))
        .build();
  }

  private Stock.State getState(Integer total) {
    if (total == 0)
      return Stock.State.EMPTY;
    else if (total >= 30)
      return Stock.State.FULL;
    else
      return Stock.State.SOME;
  }

  public void patchStocks(List<ShoeV3> shoes) {
    shoeService.patchShoes(shoes);
  }

  @Override
  public void patchStock(ShoeV3 shoe) {
    shoeService.patchShoe(shoe);
  }
}
