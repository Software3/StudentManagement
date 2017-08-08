package org.csu.sm.exception.service;

/**
 * Created by ltaoj on 2017/8/8.
 */
public class VerifyServiceException extends ServiceException{
    public VerifyServiceException() {
    }

    public VerifyServiceException(String message) {
        super(message);
    }

    public VerifyServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyServiceException(Throwable cause) {
        super(cause);
    }

    public VerifyServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
