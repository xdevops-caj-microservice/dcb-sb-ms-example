package com.example.department.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(Long id) {
        super("Resource already exists via id: " + id);
    }
}
