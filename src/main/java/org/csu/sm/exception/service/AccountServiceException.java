package org.csu.sm.exception.service;

/**
 * Created by ltaoj on 2017/8/7.
 */
public class AccountServiceException extends ServiceException{
    public AccountServiceException() {
    }

    public AccountServiceException(String message) {
        super(message);
    }

    public AccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountServiceException(Throwable cause) {
        super(cause);
    }

    public AccountServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
