package com.example.demo.controller;

import com.example.demo.Organization;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    public List<Organization> getOrganizations(){
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/organizations/{orgId}")
    public Optional<Organization> getOrganizationById(
            @PathVariable("orgId") Integer id
    ){
        return organizationService.getOrganizationById(id);
    }


    @PostMapping("/organization")
    public Organization addOrganization(
            @RequestBody Organization body){
        return organizationService.saveOrganization(body);
    }
}
