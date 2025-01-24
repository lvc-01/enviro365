package com.enviro.assessment.grad001.leandrivancittert.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String description;

    @NotNull
    private String example;

    @Autowired
    public WasteCategory(Long id, String type, String description, String example) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.example = example;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }

    public String getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setType(String type) {
        this.type = type;
    }
}

