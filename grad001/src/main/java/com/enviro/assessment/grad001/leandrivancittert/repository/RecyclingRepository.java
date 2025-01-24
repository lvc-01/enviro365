package com.enviro.assessment.grad001.leandrivancittert.repository;
import com.enviro.assessment.grad001.leandrivancittert.models.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingRepository extends JpaRepository<RecyclingTip, Long> {
    // JpaRepository provides all the necessary CRUD methods like save(), findById(), deleteById(), etc.
}

