package com.example.demo.dto.out;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShoeV3 implements IShoe {
    String name;
    Integer size;
    String color;
    Integer quantity;
}
