package com.example.demo.service;

import com.example.demo.core.ShoeMapper;
import com.example.demo.dto.out.ShoeV3;
import com.example.demo.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoeService {

  private final ShoeMapper shoeMapper;
  private final ShoeRepository shoeRepository;

  public void updateShoes(List<ShoeV3> shoes) {
    shoes.forEach(shoeV3 -> shoeRepository.findById(shoeV3.getId()).ifPresent(shoeEntity -> {
      shoeMapper.updateShoeIgnoreNull(shoeV3, shoeEntity);
      shoeRepository.save(shoeEntity);
    }));
  }

  public Integer getTotalShoes() {
    return shoeRepository.getTotalQuantity();
  }
}
