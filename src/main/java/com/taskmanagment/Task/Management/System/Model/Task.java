package com.taskmanagment.Task.Management.System.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taskmanagment.Task.Management.System.Enum.Priority;
import com.taskmanagment.Task.Management.System.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate overDue;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate created_at;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getOverDue() {
        return overDue;
    }

    public void setOverDue(LocalDate overDue) {
        this.overDue = overDue;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
}
