package com.example.demo.dto;
import java.util.List;

public record WorkerInputRequest(Integer companyType, List<WorkerDTO> workers) {}
