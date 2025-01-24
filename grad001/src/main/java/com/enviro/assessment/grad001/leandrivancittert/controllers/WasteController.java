package com.enviro.assessment.grad001.leandrivancittert.controllers;

import com.enviro.assessment.grad001.leandrivancittert.models.WasteCategory;
import com.enviro.assessment.grad001.leandrivancittert.repository.WasteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/wastecategories")
public class WasteController {

    private final WasteRepository wasteRepository;

    public WasteController(WasteRepository wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        try {
            List<WasteCategory> categories = wasteRepository.findAll();
            if (categories.isEmpty()) {
                return new ResponseEntity<>("No waste categories found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        try {
            Optional<WasteCategory> wasteCategory = wasteRepository.findById(id);
            if (wasteCategory.isPresent()) {
                return new ResponseEntity<>(wasteCategory.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Waste category not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody WasteCategory wasteCategory) {
        try {
            if (wasteCategory.getType() == null || wasteCategory.getDescription() == null || wasteCategory.getExample() == null) {
                return new ResponseEntity<>("Missing required fields", HttpStatus.BAD_REQUEST);
            }
            WasteCategory createdCategory = wasteRepository.save(wasteCategory);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        try {
            Optional<WasteCategory> existingCategory = wasteRepository.findById(id);
            if (existingCategory.isPresent()) {
                wasteCategory.setId(id);
                WasteCategory updatedCategory = wasteRepository.save(wasteCategory);
                return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Waste category not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            Optional<WasteCategory> wasteCategory = wasteRepository.findById(id);
            if (wasteCategory.isPresent()) {
                wasteRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Waste category not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
