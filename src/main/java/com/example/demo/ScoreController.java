package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ScoreController {

    Score score;

    @Autowired
    public ScoreController(Score score) {
        this.score = score;
    }

    @GetMapping("/health-check")
    String getCheckStatus() {
        return "Health is ok";
    }

}

