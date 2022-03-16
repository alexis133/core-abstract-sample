package com.example.demo.dto.out;

import com.example.demo.dto.IShoe;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Shoe.ShoeBuilder.class)
public class Shoe implements IShoe {

    String name;
    Integer size;
    String color;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ShoeBuilder {
    }
}
