package com.example.demo.service;

import com.example.demo.model.Organization;
import com.example.demo.repository.OrganisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganisationRepository organisationRepository;

    public OrganizationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public List<Organization> getAllOrganizations(){
        return organisationRepository.findAll();
    }

    public Organization saveOrganization(Organization body){
        return this.organisationRepository.save(body);
    }

    public Optional<Organization> getOrganizationById(Integer id){
        return organisationRepository.findById(id);
    }

}
