package com.example.demo.repository;

import com.example.demo.entity.ShoeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<ShoeEntity, String> {

    @Query("SELECT s FROM ShoeEntity s WHERE (:color IS NULL OR s.color LIKE %:color%) AND (:size IS NULL"
            + " OR s.size = :size)")
    List<ShoeEntity> getShoeEntityByColorAndSize(String color, Integer size);

    @Query("SELECT SUM(s.quantity) FROM ShoeEntity s")
    Integer getTotalQuantity();

}
