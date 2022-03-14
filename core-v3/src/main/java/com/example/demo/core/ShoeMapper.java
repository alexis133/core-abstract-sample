package com.example.demo.core;

import com.example.demo.dto.out.ShoeV3;
import com.example.demo.entity.ShoeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ShoeMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateShoeIgnoreNull(ShoeV3 shoe, @MappingTarget ShoeEntity shoeEntity);
}
