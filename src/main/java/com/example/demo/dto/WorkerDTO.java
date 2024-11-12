package com.example.demo.dto;

import java.util.List;

public record WorkerDTO(
        String firstName,
        String lastName,
        Integer monthHoursBudget,
        List<String> positions
) {}
