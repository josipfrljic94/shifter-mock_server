package com.example.demo.repository;

import com.example.demo.model.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity,Integer> {
PositionEntity findByPositionName(String positionName);
}
