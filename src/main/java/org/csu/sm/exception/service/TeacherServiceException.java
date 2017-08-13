package org.csu.sm.exception.service;

/**
 * Created by 51157 on 2017/8/12.
 */
public class TeacherServiceException extends ServiceException {
    public TeacherServiceException() {
    }

    public TeacherServiceException(String message) {
        super(message);
    }

    public TeacherServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherServiceException(Throwable cause) {
        super(cause);
    }

    public TeacherServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
