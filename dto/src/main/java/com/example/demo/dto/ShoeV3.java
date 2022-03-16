package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Value
@Builder
@JsonDeserialize(builder = ShoeV3.ShoeV3Builder.class)
public class ShoeV3 implements IShoe {
  @NotEmpty
  Long id;
  String name;
  Integer size;
  String color;
  @Min(value = 0, message = "Shoe quantity should not be negative")
  Integer quantity;

  @JsonPOJOBuilder(withPrefix = "")
  public static class ShoeV3Builder {
  }
}
