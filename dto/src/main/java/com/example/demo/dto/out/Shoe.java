package com.example.demo.dto.out;

import com.example.demo.dto.in.ShoeFilter.Color;
import lombok.Builder;
import lombok.Value;

import java.math.BigInteger;

@Value
@Builder
public class Shoe {

    String name;
    BigInteger size;
    Color color;


}
