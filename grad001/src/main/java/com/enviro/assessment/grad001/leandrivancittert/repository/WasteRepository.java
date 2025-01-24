package com.enviro.assessment.grad001.leandrivancittert.repository;

import com.enviro.assessment.grad001.leandrivancittert.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<WasteCategory, Long> {
    // JpaRepository provides all the necessary CRUD methods like save(), findById(), deleteById(), etc.
}

