package org.csu.sm.exception.action;

import org.csu.sm.exception.service.ServiceException;

/**
 * Created by ltaoj on 2017/8/11.
 */
public class HandleAccountServiceException extends RuntimeException{
    private ServiceException serviceException;

    public HandleAccountServiceException(ServiceException serviceException) {
        this.serviceException = serviceException;
    }

    public ServiceException getServiceException() {
        return serviceException;
    }

    public HandleAccountServiceException() {
    }

    public HandleAccountServiceException(String message) {
        super(message);
    }

    public HandleAccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleAccountServiceException(Throwable cause) {
        super(cause);
    }

    public HandleAccountServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
