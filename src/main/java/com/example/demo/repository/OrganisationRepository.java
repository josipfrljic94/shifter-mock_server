package com.example.demo.repository;

import com.example.demo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organization,Integer> {

}
