package com.example.demo.service;

import com.example.demo.model.PositionEntity;
import com.example.demo.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public PositionEntity findByName(String name){
        return positionRepository.findByPositionName(name);
    }

    public PositionEntity savePosition(PositionEntity position) {
        return positionRepository.save(position);
    }
}
