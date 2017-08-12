package org.csu.sm.web;

import org.csu.sm.domain.Result;
import org.csu.sm.exception.action.HandleInfoServiceException;
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
}