package com.example.demo.service;

import com.example.demo.dto.out.ShoeV3;

import java.util.List;


public interface ShoeService {

  void patchShoes(List<ShoeV3> shoes);

  Integer getTotalShoes();

  void patchShoe(ShoeV3 shoe);
}
