package org.csu.sm.exception.action;

import java.io.IOException;

/**
 * Created by ltaoj on 2017/8/12.
 */
public class HandleFileUploadException extends Exception{
    private IOException ioException;

    public HandleFileUploadException(IOException ioException) {
        this.ioException = ioException;
    }

    public IOException getIoException() {
        return ioException;
    }

    public HandleFileUploadException() {
    }

    public HandleFileUploadException(String message) {
        super(message);
    }

    public HandleFileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleFileUploadException(Throwable cause) {
        super(cause);
    }

    public HandleFileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
