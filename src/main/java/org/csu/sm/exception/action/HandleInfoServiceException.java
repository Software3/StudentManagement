package org.csu.sm.exception.action;

import org.csu.sm.exception.service.ServiceException;

/**
 * Created by ltaoj on 2017/8/11.
 */
public class HandleInfoServiceException extends RuntimeException{
    private ServiceException serviceException;

    public HandleInfoServiceException(ServiceException serviceException) {
        this.serviceException = serviceException;
    }

    public ServiceException getServiceException() {
        return serviceException;
    }

    public HandleInfoServiceException() {
    }

    public HandleInfoServiceException(String message) {
        super(message);
    }

    public HandleInfoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleInfoServiceException(Throwable cause) {
        super(cause);
    }

    public HandleInfoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
