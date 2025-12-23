package com.example.apirest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;


    protected Todo() {}

    public Todo(String title) {
        this.title = title;
        this.status = Status.NEW;
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public Todo(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status != null ? status : Status.NEW;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }
}
