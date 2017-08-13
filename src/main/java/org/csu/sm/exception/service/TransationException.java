package org.csu.sm.exception.service;

import org.csu.sm.domain.WithdrawInst;

/**
 * Created by ltaoj on 2017/8/13.
 */
public class TransationException extends ServiceException{
    private WithdrawInst withdrawInst;

    public TransationException(WithdrawInst withdrawInst) {
        this.withdrawInst = withdrawInst;
    }

    public WithdrawInst getWithdrawInst() {
        return withdrawInst;
    }

    public TransationException() {
    }

    public TransationException(String message) {
        super(message);
    }

    public TransationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransationException(Throwable cause) {
        super(cause);
    }

    public TransationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
