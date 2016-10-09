package org.balhau.books.cybook.domain;

import org.balhau.books.domain.ReaderSQLException;

import java.util.List;

/**
 * Created by vitorfernandes on 10/9/16.
 */
public interface SQLImporter {
    List<CybookBook> getReadingBooks() throws ReaderSQLException;
}
