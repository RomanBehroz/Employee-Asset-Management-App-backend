package com.romanyou.Employee.Asset.Management.exception;

/**
 * @Author Roman Behroz
 * Exeception will be thrown if Data already exists e.g. email addresx
 */
public class AlreadyExistException extends Exception{
    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected AlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
