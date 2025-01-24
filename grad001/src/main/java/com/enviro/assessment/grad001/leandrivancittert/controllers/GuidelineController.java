package com.enviro.assessment.grad001.leandrivancittert.controllers;

import com.enviro.assessment.grad001.leandrivancittert.models.Guideline;
import com.enviro.assessment.grad001.leandrivancittert.repository.GuidelineRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/disposalguidelines")
public class GuidelineController {
    private final GuidelineRepository guidelineRepository;
    private final ResponseEntity<String> serverError = new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    private final ResponseEntity<String> guidelineError = new ResponseEntity<>("Guideline not found", HttpStatus.NOT_FOUND);

    @Autowired
    public GuidelineController(GuidelineRepository guidelineRepository) {
        this.guidelineRepository = guidelineRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllGuidelines() {
        try {
            List<Guideline> guidelines = guidelineRepository.findAll();
            if (guidelines.isEmpty()) {
                return new ResponseEntity<>("No guidelines found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(guidelines, HttpStatus.OK);
        } catch (Exception e) {
            return serverError;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGuidelineById(@PathVariable Long id) {
        try {
            Optional<Guideline> guideline = guidelineRepository.findById(id);
            if (guideline.isPresent()) {
                return new ResponseEntity<>(guideline.get(), HttpStatus.OK);
            } else {
                return guidelineError;
            }
        } catch (Exception e) {
            return serverError;
        }
    }

    @PostMapping
    public ResponseEntity<?> createGuideline(@Valid @RequestBody Guideline guideline) {
        try {
            Guideline createdGuideline = guidelineRepository.save(guideline);
            return new ResponseEntity<>(createdGuideline, HttpStatus.CREATED);
        } catch (Exception e) {
            return serverError;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGuideline(@PathVariable Long id, @Valid @RequestBody Guideline guideline) {
        try {
            Optional<Guideline> existingGuideline = guidelineRepository.findById(id);
            if (existingGuideline.isPresent()) {
                guideline.setId(id);
                Guideline updatedGuideline = guidelineRepository.save(guideline);
                return new ResponseEntity<>(updatedGuideline, HttpStatus.OK);
            } else {
                return guidelineError;
            }
        } catch (Exception e) {
            return serverError;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuideline(@PathVariable Long id) {
        try {
            Optional<Guideline> guideline = guidelineRepository.findById(id);
            if (guideline.isPresent()) {
                guidelineRepository.deleteById(id);
                return new ResponseEntity<>("Guideline deleted", HttpStatus.OK);
            } else {
                return guidelineError;
            }
        } catch (Exception e) {
            return serverError;
        }
    }
}
