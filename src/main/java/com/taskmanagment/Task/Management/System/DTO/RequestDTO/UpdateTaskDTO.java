package com.taskmanagment.Task.Management.System.DTO.RequestDTO;

import java.time.LocalDate;

public class UpdateTaskDTO {
    private String title;
    private String description;
    private String status;
    private LocalDate overDue;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOverDue() {
        return overDue;
    }

    public void setOverDue(LocalDate overDue) {
        this.overDue = overDue;
    }
}
