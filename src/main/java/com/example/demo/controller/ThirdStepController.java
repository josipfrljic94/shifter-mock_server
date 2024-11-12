package com.example.demo.controller;

import com.example.demo.dto.WorkerDTO;
import com.example.demo.dto.WorkerInputRequest;
import com.example.demo.model.PositionEntity;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerEntity;
import com.example.demo.service.PositionService;
import com.example.demo.service.WorkerService;
import com.example.demo.utils.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
public class ThirdStepController {
    private static final Logger logger = LoggerFactory.getLogger(ThirdStepController.class);
    private final WorkerService workerService;
    private final PositionService positionService;

    public ThirdStepController(WorkerService workerService, PositionService positionService) {
        this.workerService = workerService;
        this.positionService = positionService;
    }

    @PostMapping("/addworkersFile")
    public ResponseEntity<String> uploadExcel(@RequestParam("companyType") Integer companyType,
                                              @RequestParam("file") MultipartFile file) {
        try {
            List<Worker> data = CSVHelper.parseCSV(file);
            for (Worker worker : data) {
                if (worker != null) {
                    WorkerEntity tmpWorker = new WorkerEntity();
                    tmpWorker.setFirstName(worker.getIme());
                    tmpWorker.setLastName(worker.getPrezime());

                    List<PositionEntity> workerPositions = new ArrayList<>();
                    for (String positionName : worker.getPozicije()) {
                        PositionEntity position = positionService.findByName(positionName);
                        if (position == null) {
                            position = new PositionEntity(positionName);
                            positionService.savePosition(position);
                            workerPositions.add(position);
                        }

                    }

                    tmpWorker.setPositions(workerPositions);
                    tmpWorker.setMonthHoursBudget(worker.getBrojSati());
                    workerService.saveWorker(tmpWorker);
                }
            }
            return ResponseEntity.ok("File uploaded and data processed successfully. Company " + data.get(0).getIme() + " type is " + companyType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file: " + e.getMessage());
        }
    }

    @PostMapping("/addworkersInputs")
    public ResponseEntity<String> generateByInputs(@RequestBody() WorkerInputRequest body) {
        List<WorkerEntity> workerEntities = new ArrayList<WorkerEntity>();
        List<WorkerDTO> workers = body.workers();
        int companyType = body.companyType();
        try {
            for (var w : workers) {
                WorkerEntity tmpWorkerEntity = getWorkerEntity(w,positionService);
                workerEntities.add(tmpWorkerEntity);
            }
            logger.info("type is {}and number of workers is {}", body.companyType(), body.workers().size());
            workerService.saveAllWorker(workerEntities);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error is "+e.getMessage());
        }
    }

    private static WorkerEntity getWorkerEntity(WorkerDTO w,PositionService positionService) {
        WorkerEntity tmpWorkerEntity = new WorkerEntity();
        tmpWorkerEntity.setFirstName(w.firstName());
        tmpWorkerEntity.setLastName(w.lastName());
        tmpWorkerEntity.setMonthHoursBudget(w.monthHoursBudget());
        List<PositionEntity> workerPositions = new ArrayList<>();
        var positions = w.positions();
                for (String positionName : positions) {
                    PositionEntity position = positionService.findByName(positionName);
                    if (position == null) {
                        position = new PositionEntity(positionName);
                        positionService.savePosition(position);
                        workerPositions.add(position);
                    }

                }
        tmpWorkerEntity.setPositions(workerPositions);
        return tmpWorkerEntity;
    }
}
