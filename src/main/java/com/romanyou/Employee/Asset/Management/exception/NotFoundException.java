package com.romanyou.Employee.Asset.Management.exception;

/**
 * @Author Roman Behroz
 * Exeception will be thrown if Data  is not founed  e.g. an employee
 */
public class NotFoundException extends Exception{
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    protected NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
