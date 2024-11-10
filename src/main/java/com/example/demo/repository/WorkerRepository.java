package com.example.demo.repository;

import com.example.demo.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer> {
}
