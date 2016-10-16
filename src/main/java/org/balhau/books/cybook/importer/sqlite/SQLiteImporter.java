package org.balhau.books.cybook.importer.sqlite;

import org.balhau.books.cybook.domain.CybookAuthor;
import org.balhau.books.cybook.domain.CybookBook;
import org.balhau.books.cybook.domain.SQLImporter;
import org.balhau.books.domain.exceptions.InvalidArgumentException;
import org.balhau.books.domain.exceptions.ReaderSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static org.balhau.books.utils.SqlUtilities.*;
import static org.balhau.books.cybook.importer.sqlite.SQLiteQueries.*;
/**
 * This implementation retrieve meaningful data from SQLite database presented in Cybook devices
 */
public class SQLiteImporter implements SQLImporter{


    private Connection conn;

    /**
     * @param path Path for the sqlite database
     */
    public SQLiteImporter(String path) throws ReaderSQLException{
        try {
            conn = getSQLiteConnection(path);
        }catch (Exception ex){
            throw new ReaderSQLException(ex);
        }
    }

    @Override
    public List<CybookAuthor> getAuthors() throws ReaderSQLException {
        return getAuthors(GET_AUTHORS_QUERY);
    }

    /**
     * This will return a list of books that are currently being readed
     * @return {@link List} List of books
     */
    @Override
    public List<CybookBook> getReadingBooks() throws ReaderSQLException{
        return getBooks(READING_BOOKS_QUERY);
    }

    @Override
    public List<CybookBook> getBooks() throws ReaderSQLException {
        return getBooks(GET_ALL_BOOKS_QUERY);
    }

    @Override
    public List<CybookBook> getBooksByAuthor(CybookAuthor author) throws ReaderSQLException,InvalidArgumentException {
        if(author==null || author.getId()<=0){
            throw new InvalidArgumentException("Invalid author object");
        }
        return getBooks(String.format(GET_BOOKS_BY_AUTHOR_QUERY,author.getId()));
    }

    private List<CybookBook> getBooks(String query) throws ReaderSQLException {
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return readBooks(rs);
        }catch (Exception e){
            throw new ReaderSQLException(e);
        }
    }

    private List<CybookAuthor> getAuthors(String query) throws ReaderSQLException{
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return readAuthors(rs);
        }catch (Exception e){
            throw new ReaderSQLException(e);
        }
    }

    private List<CybookBook> readBooks(ResultSet rs) throws Exception {
        List<CybookBook> books=new ArrayList<>();
        CybookBook.Builder b;
        while(rs.next()){
            b=new CybookBook.Builder();
            b.BookId(rs.getInt(1));
            b.Pages(rs.getInt(2));
            b.CurrentPage(rs.getInt(3));
            b.LastRead(new Date(rs.getInt(4)*1000L));
            b.PublicationDate(rs.getString(5));
            b.Publisher(rs.getString(6));
            b.Title(rs.getString(7));
            b.Description(rs.getString(8));
            b.BookURI(rs.getString(9));
            b.Author(rs.getString(10));
            b.IsReaded(rs.getInt(11)==1?true:false);
            b.DocumentTime(new Date(rs.getInt(12)*1000L));
            books.add(b.build());
        }
        return books;
    }

    private List<CybookAuthor> readAuthors(ResultSet rs) throws Exception{
        List<CybookAuthor> authors = new ArrayList<>();
        while(rs.next()){
            authors.add(new CybookAuthor(
                    rs.getInt(1),
                    rs.getString(2)
            ));
        }
        return authors;
    }
}
