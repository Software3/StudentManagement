package org.csu.sm.web;

import org.csu.sm.domain.Result;
import org.csu.sm.exception.action.HandleFileUploadException;
import org.csu.sm.exception.action.HandleInfoServiceException;
import org.csu.sm.exception.action.HandleTransationException;
import org.csu.sm.util.ConfigUtil;
import org.csu.sm.util.IOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ltaoj on 2017/8/7.
 */
public abstract class AbstractActionBean {
    @ExceptionHandler(HandleInfoServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Result infoServiceError(HandleInfoServiceException e) {
        return new Result(Result.RESULT_ERROR, e);
    }

    @ExceptionHandler(HandleFileUploadException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Result fileUploadError(HandleFileUploadException e) {
        return new Result(Result.RESULT_ERROR, e);
    }

    @ExceptionHandler(HandleTransationException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Result transationError(HandleTransationException e) {
        String path = ConfigUtil.getPath();
        path = path.substring(0, path.lastIndexOf(System.getProperty("file.separator")));
        IOUtil.removeFile(path, e.getTransationException().getWithdrawInst().getDescription());
        return new Result(Result.RESULT_ERROR, e);
    }
}