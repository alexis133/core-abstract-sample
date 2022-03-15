package com.example.demo.dto.out;

import com.example.demo.dto.IShoe;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Shoes {

    List<IShoe> shoes;


}
