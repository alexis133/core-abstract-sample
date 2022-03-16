package com.example.demo.dto.out;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Stock {

    public enum State {
        EMPTY, SOME, FULL
    }

    State state;
    Shoes shoes;

}
