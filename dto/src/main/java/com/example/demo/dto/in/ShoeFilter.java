package com.example.demo.dto.in;

import lombok.Value;

import java.util.Optional;

@Value
public class ShoeFilter {

    Integer size;
    String color;

    public Optional<Integer> getSize() {
        return Optional.ofNullable(size);
    }

    public Optional<String> getColor() {
        return Optional.ofNullable(color);
    }

}
