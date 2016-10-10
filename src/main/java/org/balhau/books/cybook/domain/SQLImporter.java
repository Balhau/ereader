package org.balhau.books.cybook.domain;

import org.balhau.books.domain.ReaderSQLException;

import java.util.List;

/**
 * This is a contract that all SQL importers should obey
 */
public interface SQLImporter {
    List<CybookBook> getReadingBooks() throws ReaderSQLException;
}
