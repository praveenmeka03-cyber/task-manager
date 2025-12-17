package com.praveen.copilot.taskmanager.exception;

/**
 * Custom exception for resource not found scenarios.
 * Thrown when a requested resource (e.g., Task) doesn't exist in the database.
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
    }
}
