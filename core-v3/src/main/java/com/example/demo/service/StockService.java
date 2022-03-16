package com.example.demo.service;

import com.example.demo.dto.ShoeV3;
import com.example.demo.dto.out.Stock;
import com.example.demo.exception.NoSuchShoeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {

  Stock stocks(Integer version);

  void patchStocks(List<ShoeV3> shoes) throws NoSuchShoeException;

  void patchStock(ShoeV3 shoe) throws NoSuchShoeException;
}
