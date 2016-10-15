package com.balhau.books.domain

import org.balhau.books.domain.exceptions.InvalidArgumentException
import org.balhau.books.domain.exceptions.ReaderSQLException
import spock.lang.Specification

/**
 * Created by vitorfernandes on 10/15/16.
 */
class ExceptionsTest extends Specification {

    def setup(){

    }

    def "Test exception string constructors"(){
        ReaderSQLException sqlEx
        InvalidArgumentException iargEx
        when:
            sqlEx = new ReaderSQLException("ERROR")
            iargEx = new InvalidArgumentException("ERROR")
        then:
            sqlEx != null
            iargEx != null
    }

    def "Test exception throwable constructor"(){
        ReaderSQLException sqlEx
        InvalidArgumentException iargEx
        when:
            sqlEx = new ReaderSQLException(new Exception())
            iargEx = new InvalidArgumentException(new Exception())
        then:
            sqlEx != null
            iargEx != null
    }

    def "Test exception string and throwable constructor"(){
        ReaderSQLException sqlEx
        InvalidArgumentException iargEx
        when:
            sqlEx = new ReaderSQLException("ERROR",new Exception())
            iargEx = new InvalidArgumentException("ERROR",new Exception())
        then:
            sqlEx != null
            iargEx != null
    }

}
