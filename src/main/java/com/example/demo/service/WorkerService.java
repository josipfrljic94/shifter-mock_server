package com.example.demo.service;

import com.example.demo.model.PositionEntity;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerEntity;
import com.example.demo.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity saveWorker(WorkerEntity body){
        return this.workerRepository.save(body);
    }

    public List<WorkerEntity> saveAllWorker(List<WorkerEntity> workers){
        return this.workerRepository.saveAll(workers);
    }

}
