package org.balhau.books.cybook.domain;

import org.balhau.books.domain.exceptions.InvalidArgumentException;
import org.balhau.books.domain.exceptions.ReaderSQLException;

import java.util.List;

/**
 * This is a contract that all SQL importers should obey
 */
public interface SQLImporter {
    List<CybookBook> getReadingBooks() throws ReaderSQLException;
    List<CybookAuthor> getAuthors() throws ReaderSQLException;
    List<CybookBook> getBooksByAuthor(CybookAuthor author) throws ReaderSQLException, InvalidArgumentException;
}
