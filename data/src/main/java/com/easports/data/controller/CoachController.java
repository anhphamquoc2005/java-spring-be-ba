package com.easports.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easports.analyze.EASportAnalyzer;
import com.easports.data.service.CoachService;

@RestController
public class CoachController {
    
    @Value("${team.name}")
    private String teamName;

    @Value("${team.stadium}")
    private String teamStadium;

    private CoachService tacticalCoach;
    private CoachService fitnessService;
    private EASportAnalyzer eaSportAnalyzer;

    @Autowired
    public CoachController(@Qualifier("tacticalCoach") CoachService tacticalCoach,@Qualifier("fitnessService") CoachService fitnessService, EASportAnalyzer eaSportAnalyzer) {
        this.tacticalCoach = tacticalCoach;
        this.fitnessService = fitnessService;
        this.eaSportAnalyzer = eaSportAnalyzer;
    }

    @GetMapping("/api/team/info")
    public String getTeam() {
        return "Đội " + teamName + ". Sở hữu sân vận động " + teamStadium;
    }

    @GetMapping("/api/team/main-training")
    public String tacticalTraining() {
        return tacticalCoach.getDailyDrill();
    }

    @GetMapping("/api/team/fitness")
    public String fitnessTraining() {
        return fitnessService.getDailyDrill();
    }

    @GetMapping("/api/team/data")
    public String analyzer() {
        return eaSportAnalyzer.analyzerOpponent();
    }
}
