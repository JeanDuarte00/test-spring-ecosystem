package com.fractal.domain.entity.enumerator;

public enum Errors {

    WORKER_NOT_FOUND("COULD_NOT_FIND_WORKER");

    private final String value;
    Errors(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
