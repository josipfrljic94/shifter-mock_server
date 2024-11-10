package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "position_name", unique = true)
    private String positionName;

    @ManyToMany(mappedBy = "positions")
    private List<WorkerEntity> workers;

    // Getteri i setteri

    public PositionEntity() {}

    public PositionEntity(String positionName) {
        this.positionName = positionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<WorkerEntity> getWorkers() {
        return workers;
    }

    public void setWorkers(List<WorkerEntity> workers) {
        this.workers = workers;
    }
}
