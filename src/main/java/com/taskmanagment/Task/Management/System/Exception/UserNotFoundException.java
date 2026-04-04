package com.taskmanagment.Task.Management.System.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(long userId) {
        super(HttpStatus.NOT_FOUND,"User %d not found".formatted(userId));
    }
}
