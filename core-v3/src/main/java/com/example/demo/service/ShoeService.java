package com.example.demo.service;

import com.example.demo.dto.out.ShoeV3;

import java.util.List;


public interface ShoeService {

  void updateShoes(List<ShoeV3> shoes);

  Integer getTotalShoes();
}
