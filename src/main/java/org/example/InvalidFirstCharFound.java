package org.example;

public class InvalidFirstCharFound extends RuntimeException{
    public InvalidFirstCharFound(String errorMessage) {
        super(errorMessage);
    }
}
