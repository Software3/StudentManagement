package org.csu.sm.exception.action;

import org.csu.sm.exception.service.TransationException;

/**
 * Created by ltaoj on 2017/8/13.
 */
public class HandleTransationException extends RuntimeException{
    private TransationException transationException;

    public HandleTransationException(TransationException transationException) {
        this.transationException = transationException;
    }

    public TransationException getTransationException() {
        return transationException;
    }

    public HandleTransationException() {
    }

    public HandleTransationException(String message) {
        super(message);
    }

    public HandleTransationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleTransationException(Throwable cause) {
        super(cause);
    }

    public HandleTransationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
