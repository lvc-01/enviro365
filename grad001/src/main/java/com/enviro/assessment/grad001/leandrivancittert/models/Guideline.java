package com.enviro.assessment.grad001.leandrivancittert.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Guideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String wasteType;

    @NotBlank
    private String description;

    @NotBlank
    private String methodOfDisposal;

    @NotBlank
    private String disposalLocation;

    @Autowired
    public Guideline(String wasteType, String description, String methodOfDisposal, String disposalLocation) {
        this.wasteType = wasteType;
        this.description = description;
        this.methodOfDisposal = methodOfDisposal;
        this.disposalLocation = disposalLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethodOfDisposal() {
        return methodOfDisposal;
    }

    public void setMethodOfDisposal(String methodOfDisposal) {
        this.methodOfDisposal = methodOfDisposal;
    }

    public String getDisposalLocation() {
        return disposalLocation;
    }

    public void setDisposalLocation(String disposalLocation) {
        this.disposalLocation = disposalLocation;
    }
}
