package com.example.demo.entity;


import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.Shoe;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "shoe")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShoeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer size;
    @Enumerated(EnumType.STRING)
    ShoeFilter.Color color;
    Integer quantity;

    public ShoeEntity(Integer quantity, Shoe shoe) {
        this.name = shoe.getName();
        this.size = shoe.getSize().intValue();
        this.color = shoe.getColor();
        this.quantity = quantity;
    }
}
