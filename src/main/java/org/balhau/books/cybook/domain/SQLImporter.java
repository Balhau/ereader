package org.balhau.books.cybook.domain;

import org.balhau.books.domain.exceptions.InvalidArgumentException;
import org.balhau.books.domain.exceptions.ReaderSQLException;

import java.util.List;

/**
 *
 * This is a contract that all SQL importers should obey
 */
public interface SQLImporter {
    /**
     * This should return all the books the user is currently reading
     * @return {@link List} A list of {@link CybookBook} elements
     * this @throws {@link ReaderSQLException} Exception for sql operations
     */
    List<CybookBook> getReadingBooks() throws ReaderSQLException;

    /**
     * This should return all the authors available
     * @return {@link List} A list of {@link CybookAuthor} elements
     * this @throws {@link ReaderSQLException} Exception for sql operations
     */
    List<CybookAuthor> getAuthors() throws ReaderSQLException;

    /**
     * This should return the books writen by a specific author
     * @param author {@link CybookAuthor} Book author object
     * @return {@link List} List of {@link CybookBook} elements
     * this @throws {@link ReaderSQLException} Exception for sql operations
     */
    List<CybookBook> getBooksByAuthor(CybookAuthor author) throws ReaderSQLException, InvalidArgumentException;

    /**
     * This should return all the books presented in your library
     * @return {@link List} List of {@link CybookBook} elements
     * @throws ReaderSQLException
     */
    List<CybookBook> getBooks() throws ReaderSQLException;
}
