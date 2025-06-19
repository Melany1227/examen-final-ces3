package com.ces3.examen.examen_final.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String subject;

    @NotNull
    @Min(0)
    private Double salary;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    public Teacher() {}

    public Teacher(String name, String lastName, String subject, Double salary, String email) {
        this.name = name;
        this.lastName = lastName;
        this.subject = subject;
        this.salary = salary;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double calcularSalarioAnual() {
        return this.salary * 12;
    }

    @Override
    public String toString() {
        return name + " " + lastName + " - " + subject + " - $" + salary + " mensual";
    }
}
