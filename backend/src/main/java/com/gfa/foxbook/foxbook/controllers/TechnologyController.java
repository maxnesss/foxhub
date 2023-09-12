package com.gfa.foxbook.foxbook.controllers;

import com.gfa.foxbook.foxbook.services.interfaces.TechnologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public")
@CrossOrigin(origins = {"http://localhost:4200", "http://foxhub.gfapp.eu", "https://foxhub.gfapp.eu"}, maxAge = 3600, allowCredentials = "true")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/technologies")
    public ResponseEntity<?> getAllTechnologies() {
        return ResponseEntity.ok(technologyService.getAllTechnologies());
    }
}
