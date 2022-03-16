package com.example.demo.service;

import com.example.demo.dto.ShoeV3;
import com.example.demo.exception.NoSuchShoeException;

import java.util.List;


public interface ShoeService {

  void patchShoes(List<ShoeV3> shoes) throws NoSuchShoeException;

  Integer getTotalShoes();

  void patchShoe(ShoeV3 shoe) throws NoSuchShoeException;
}
