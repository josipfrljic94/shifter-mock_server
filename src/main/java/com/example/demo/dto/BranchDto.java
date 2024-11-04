package com.example.demo.dto;

public record BranchDto(
        String name,
        String contactEmail,
        String contactNumber,
        Integer organizationId
) {
}
