package org.csu.sm.exception.service;

/**
 * Created by ltaoj on 2017/8/8.
 */
public class InfoManageServiceException extends ServiceException{
    public InfoManageServiceException() {
    }

    public InfoManageServiceException(String message) {
        super(message);
    }

    public InfoManageServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfoManageServiceException(Throwable cause) {
        super(cause);
    }

    public InfoManageServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
