package com.example.demo.controller;

import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BranchController {
    private final BranchRepository branchRepository;


    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
    @PostMapping("/branches")
    Branch createBranch(
            @RequestBody Branch body
    ){
       return this.branchRepository.save(body);
    }

    @GetMapping("/branches")
    List<Branch> getBranches(){
        return this.branchRepository.findAll();
    }

    @GetMapping("/branches/{branchId}")
    Optional<Branch> getBranches(@PathVariable("branchId") Integer branchId){
        return this.branchRepository.findById(branchId);
    }

    @DeleteMapping("/branches/{branchId}")
    void deleteBranch(@PathVariable("branchId") Integer branchId){
         this.branchRepository.deleteById(branchId);
    }
}
