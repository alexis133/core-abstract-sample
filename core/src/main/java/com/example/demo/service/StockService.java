package com.example.demo.service;

import com.example.demo.dto.out.Shoe;
import com.example.demo.dto.out.Shoes;
import com.example.demo.dto.out.Stock;
import com.example.demo.entity.ShoeEntity;
import com.example.demo.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final ShoeRepository shoeRepository;

    public Stock stocks() {
        List<ShoeEntity> shoeEntities = shoeRepository.findAll();
        Stock.State state = null;
        List<Shoe> shoeList = shoeEntities.stream().map(shoeEntity -> Shoe.builder()
                .color(shoeEntity.getColor())
                .name(shoeEntity.getName())
                .size(BigInteger.valueOf(shoeEntity.getSize()))
                .build()).collect(Collectors.toList());
        Shoes shoes = Shoes.builder().shoes(shoeList).build();
        return Stock.builder().shoes(shoes)
                .state(Stock.State.EMPTY).build();
    }
}
