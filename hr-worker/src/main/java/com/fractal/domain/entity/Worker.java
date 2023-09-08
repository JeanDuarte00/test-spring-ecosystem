package com.fractal.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "worker")
public class Worker implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 1)
    private Double dailyIncome;

    public Worker(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getDailyIncome() {
        return dailyIncome;
    }
    public Double getActualMonthIncome() {
        return  getIncomeBasedOnManyDays(LocalDate.now().lengthOfMonth());
    }
    public Double getActualYearIncome() {
        return  getIncomeBasedOnManyDays(LocalDate.now().lengthOfYear());
    }
    public Double getIncomeBasedOnManyDays(@NotNull Integer days) {
        return dailyIncome * days;
    }
    public Worker changeName(@NotNull String newName){
        this.name = newName;
        return this;
    }
    public Worker changeIncome(@NotNull Double newDailyIncome){
        this.dailyIncome = newDailyIncome;
        return this;
    }
}
