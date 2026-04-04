package com.taskmanagment.Task.Management.System.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class TaskNotFoundException extends ResponseStatusException {
    public TaskNotFoundException(long taskId) {
        super(HttpStatus.NOT_FOUND,"There is no task with %d task id".formatted(taskId));
    }
}
