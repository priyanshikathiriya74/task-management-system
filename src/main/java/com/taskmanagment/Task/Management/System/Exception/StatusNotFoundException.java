package com.taskmanagment.Task.Management.System.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StatusNotFoundException extends ResponseStatusException {
    public StatusNotFoundException(String s) {
        super(HttpStatus.NOT_FOUND,"Status %s not found".formatted(s));
    }
}
