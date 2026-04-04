package com.taskmanagment.Task.Management.System.DTO.RequestDTO;

import com.taskmanagment.Task.Management.System.Enum.Priority;

import java.time.LocalDate;

public class RequestDTO {
    private String title;
    private String description;
    private Priority priority;
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
}
