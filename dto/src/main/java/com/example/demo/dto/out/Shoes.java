package com.example.demo.dto.out;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Shoes {

    List<Shoe> shoes;


}
