package com.example.demo.service.impl;

import com.example.demo.dto.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.exception.NoSuchShoeException;
import com.example.demo.service.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.example.demo.core", "com.example.demo.service", "com.example.demo.facade"})
@EntityScan(basePackages = {"com.example.demo.entity"})
@EnableJpaRepositories("com.example.demo.repository")
@SpringBootTest(classes = {StockServiceTest.class})
@Sql(scripts = "/setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class StockServiceTest {

  @Autowired
  private StockService stockService;

  public StockServiceTest() {
  }

  @Test
  @Transactional
  void getInitialStockReturnsSomeStateStock() {
    Stock actual = stockService.stocks(3);
    Assertions.assertEquals(Stock.State.SOME, actual.getState());
  }

  @Test
  @Transactional
  void updateShoeQuantitiesToZeroUpdatesToEmptyStateStock() throws Exception {
    ShoeV3 shoe1 = ShoeV3.builder()
        .id(1L)
        .quantity(0)
        .build();
    ShoeV3 shoe2 = ShoeV3.builder()
        .id(2L)
        .quantity(0)
        .build();
    ShoeV3 shoe3 = ShoeV3.builder()
        .id(3L)
        .quantity(0)
        .build();

    stockService.patchStocks(List.of(shoe1, shoe2, shoe3));

    Stock actual = stockService.stocks(3);
    Assertions.assertEquals(Stock.State.EMPTY, actual.getState());
  }

  @Test
  @Transactional
  void updateShoeUpdatesToFullStateStock() throws Exception {
    ShoeV3 shoe1 = ShoeV3.builder()
        .id(1L)
        .quantity(10)
        .build();
    ShoeV3 shoe2 = ShoeV3.builder()
        .id(2L)
        .quantity(10)
        .build();
    ShoeV3 shoe3 = ShoeV3.builder()
        .id(3L)
        .quantity(10)
        .build();

    stockService.patchStocks(List.of(shoe1, shoe2, shoe3));

    Stock actual1 = stockService.stocks(3);
    Assertions.assertEquals(Stock.State.FULL, actual1.getState());
  }

  @Test
  @Transactional
  void updateNonExistentShoeThrowsNoSuchShoeException() {
    ShoeV3 shoe = ShoeV3.builder()
        .id(4L)
        .quantity(10)
        .build();

    Assertions.assertThrows(NoSuchShoeException.class, () -> stockService.patchStock(shoe));
  }
}