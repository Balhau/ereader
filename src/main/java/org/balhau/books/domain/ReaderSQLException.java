package org.balhau.books.domain;

/**
 * Typed exception for SQL operations
 */
public class ReaderSQLException extends Exception {

	private static final long serialVersionUID = 4803262425012154019L;

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
