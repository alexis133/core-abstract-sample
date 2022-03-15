package com.example.demo.dto.out;

import com.example.demo.dto.IShoe;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Shoe implements IShoe {

    String name;
    Integer size;
    String color;


}
