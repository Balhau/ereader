package org.balhau.books.domain.exceptions;

/**
 * Created by vitorfernandes on 10/15/16.
 */
public class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String message){
        super(message);
    }

    public InvalidArgumentException(Throwable cause){
        super(cause);
    }

    public InvalidArgumentException(String message,Throwable cause){
        super(message,cause);
    }


}
