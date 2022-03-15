package com.example.demo.service.impl;

import com.example.demo.core.ShoeMapper;
import com.example.demo.dto.out.ShoeV3;
import com.example.demo.entity.ShoeEntity;
import com.example.demo.repository.ShoeRepository;
import com.example.demo.service.ShoeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ShoeServiceImpl implements ShoeService {
  private final ShoeMapper shoeMapper;
  private final ShoeRepository shoeRepository;

  public void updateShoes(List<ShoeV3> shoes) {
    shoes.forEach(shoeV3 -> {
      Optional<ShoeEntity> shoe = shoeRepository.findById(shoeV3.getId());

      ShoeEntity shoeEntity = shoe.orElseGet(() -> ShoeEntity
          .builder()
          .build());
      shoeMapper.updateShoeIgnoreNull(shoeV3, shoeEntity);
      shoeRepository.save(shoeEntity);
    });

  }

  public Integer getTotalShoes() {
    return shoeRepository.getTotalQuantity();
  }

}
