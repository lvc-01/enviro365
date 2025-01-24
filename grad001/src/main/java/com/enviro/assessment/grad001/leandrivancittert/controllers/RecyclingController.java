package com.enviro.assessment.grad001.leandrivancittert.controllers;

import com.enviro.assessment.grad001.leandrivancittert.models.RecyclingTip;
import com.enviro.assessment.grad001.leandrivancittert.repository.RecyclingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/recyclingtips")
public class RecyclingController {

    private final RecyclingRepository recyclingRepository;

    public RecyclingController(RecyclingRepository recyclingRepository) {
        this.recyclingRepository = recyclingRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllTips() {
        try {
            List<RecyclingTip> tips = recyclingRepository.findAll();
            if (tips.isEmpty()) {
                return new ResponseEntity<>("No tips found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipById(@PathVariable Long id) {
        try {
            Optional<RecyclingTip> tip = recyclingRepository.findById(id);
            if (tip.isPresent()) {
                return new ResponseEntity<>(tip.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tip not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTip(@RequestBody RecyclingTip tip) {
        try {
            if (tip.getType() == null || tip.getInstruction() == null || tip.getLocation() == null) {
                return new ResponseEntity<>("Missing required fields", HttpStatus.BAD_REQUEST);
            }
            RecyclingTip newTip = recyclingRepository.save(tip);
            return new ResponseEntity<>(newTip, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTip(@PathVariable Long id, @RequestBody RecyclingTip tip) {
        try {
            Optional<RecyclingTip> existingTip = recyclingRepository.findById(id);
            if (existingTip.isPresent()) {
                tip.setId(id);
                RecyclingTip updatedTip = recyclingRepository.save(tip);
                return new ResponseEntity<>(updatedTip, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tip not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTip(@PathVariable Long id) {
        try {
            Optional<RecyclingTip> tip = recyclingRepository.findById(id);
            if (tip.isPresent()) {
                recyclingRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Tip not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
