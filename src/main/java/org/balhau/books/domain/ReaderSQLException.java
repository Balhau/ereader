package org.balhau.books.domain;

/**
 * Created by vitorfernandes on 10/9/16.
 */
public class ReaderSQLException extends Exception {

    public ReaderSQLException(String message){
        super(message);
    }

    public ReaderSQLException(Throwable cause){
        super(cause);
    }

    public ReaderSQLException(String message,Throwable cause){
        super(message,cause);
    }
}
