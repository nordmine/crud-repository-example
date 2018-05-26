package ru.devmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Country with id=" + id + " not found");
    }

    public NotFoundException(String name) {
        super("Country with name=" + name + " not found");
    }
}
