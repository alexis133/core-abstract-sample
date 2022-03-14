package com.example.demo.core;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.IShoe;
import com.example.demo.dto.out.ShoeV3;
import com.example.demo.dto.out.Shoes;
import com.example.demo.entity.ShoeEntity;
import com.example.demo.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Implementation(version = 3)
@RequiredArgsConstructor
public class ShoeCoreV3 extends AbstractShoeCore {

  private final ShoeRepository shoeRepository;

  @Override
  public Shoes search(ShoeFilter filter) {
    List<ShoeEntity> shoeEntityList = shoeRepository.getShoeEntityByColorAndSize(
        filter.getColor().orElse(null),
        filter.getSize().orElse(null));

    List<IShoe> shoes = shoeEntityList
        .stream()
        .map((Function<ShoeEntity, IShoe>) shoeEntity -> ShoeV3.builder()
            .id(shoeEntity.getId())
            .name(shoeEntity.getName())
            .color(shoeEntity.getColor())
            .size(shoeEntity.getSize())
            .quantity(shoeEntity.getQuantity())
            .build())
        .collect(Collectors.toList());

    return Shoes.builder().shoes(shoes).build();
  }
}
