package com.example.demo.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "worker_positions",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private List<PositionEntity> positions;

    @Column
    private int monthHoursBudget;

    // Getteri i setteri

    public WorkerEntity() {}

    public WorkerEntity(String firstName, String lastName, List<PositionEntity> positions, int monthHoursBudget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.positions = positions;
        this.monthHoursBudget = monthHoursBudget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionEntity> positions) {
        this.positions = positions;
    }

    public int getMonthHoursBudget() {
        return monthHoursBudget;
    }

    public void setMonthHoursBudget(int monthHoursBudget) {
        this.monthHoursBudget = monthHoursBudget;
    }
}