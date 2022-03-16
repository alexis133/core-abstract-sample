package com.example.demo.service.impl;

import com.example.demo.core.ShoeMapper;
import com.example.demo.dto.ShoeV3;
import com.example.demo.entity.ShoeEntity;
import com.example.demo.exception.NoSuchShoeException;
import com.example.demo.repository.ShoeRepository;
import com.example.demo.service.ShoeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ShoeServiceImpl implements ShoeService {
  private final ShoeMapper shoeMapper;
  private final ShoeRepository shoeRepository;

  public void patchShoes(List<ShoeV3> shoes) throws NoSuchShoeException {
    for (ShoeV3 shoeV3 : shoes) {
      ShoeEntity shoeEntity = shoeRepository.findById(shoeV3.getId()).orElseThrow(() ->
          new NoSuchShoeException("No shoe id:" + shoeV3.getId() + " found in store"));

      shoeMapper.updateShoeIgnoreNull(shoeV3, shoeEntity);
      shoeRepository.save(shoeEntity);
    }
  }

  public Integer getTotalShoes() {
    return shoeRepository.getTotalQuantity();
  }

  @Override
  public void patchShoe(ShoeV3 shoeV3) throws NoSuchShoeException {
    ShoeEntity shoeEntity = shoeRepository.findById(shoeV3.getId()).orElseThrow(() ->
        new NoSuchShoeException("No shoe id:" + shoeV3.getId() + " found in store"));

    Integer newQuantity = shoeV3.getQuantity() + shoeEntity.getQuantity();
    shoeMapper.updateShoeIgnoreNull(shoeV3, shoeEntity);
    shoeEntity.setQuantity(newQuantity);

    shoeRepository.save(shoeEntity);
  }

}
