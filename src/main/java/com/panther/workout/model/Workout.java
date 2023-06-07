package com.panther.workout.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class Workout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;

    @Column
    private Integer calories;

    public Workout(Integer id, String type, Integer calories) {
        this.id = id;
        this.type = type;
        this.calories = calories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) && Objects.equals(type, workout.type) && Objects.equals(calories, workout.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, calories);
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", calories=" + calories +
                '}';
    }
}
