package com.fractal.domain.entity.exception;

import com.fractal.domain.entity.enumerator.Errors;

public class WorkerNotFound extends RuntimeException{

    public WorkerNotFound() {
        super(Errors.WORKER_NOT_FOUND.getValue());
    }
    public WorkerNotFound(String message) {
        super(message);
    }
    public WorkerNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
