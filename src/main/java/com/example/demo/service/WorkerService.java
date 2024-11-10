package com.example.demo.service;

import com.example.demo.model.WorkerEntity;
import com.example.demo.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity saveWorker(WorkerEntity body){
        return this.workerRepository.save(body);
    }
}
