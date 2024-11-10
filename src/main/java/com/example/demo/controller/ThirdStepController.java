package com.example.demo.controller;

import com.example.demo.model.Worker;
import com.example.demo.utils.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ThirdStepController {
    private static final Logger logger = LoggerFactory.getLogger(ThirdStepController.class);

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadExcel(@RequestParam("companyType") Integer companyType,
                                              @RequestParam("file") MultipartFile file
    ) {
        try {
            List<Worker> data = CSVHelper.parseCSV(file);
            logger.info(data.get(0).getIme());
        //save in db

            return ResponseEntity.ok("File uploaded and data processed successfully. "  + "company " + data.get(0).getIme() + " type is" +  companyType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file: "  + e.getMessage());
        }
    }
}
