package org.balhau.books.cybook.importer.sqlite;

import org.balhau.books.cybook.domain.CybookAuthor;
import org.balhau.books.cybook.domain.CybookBook;
import org.balhau.books.cybook.domain.SQLImporter;
import org.balhau.books.domain.exceptions.InvalidArgumentException;
import org.balhau.books.domain.exceptions.ReaderSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.balhau.books.utils.SqlUtilities.*;
import static org.balhau.books.cybook.importer.sqlite.SQLiteQueries.*;
/**
 * Created by vitorfernandes on 10/9/16.
 */
public class SQLiteImporter implements SQLImporter{


    private static final String DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss+hh:mm";

    private final String path;
    private final SimpleDateFormat format;
    private Connection conn;

    /**
     * @param path Path for the sqlite database
     */
    public SQLiteImporter(String path) throws ReaderSQLException{
        try {
            this.path = path;
            this.format=new SimpleDateFormat(DATE_FORMAT);
            conn = getSQLiteConnection(path);
        }catch (Exception ex){
            throw new ReaderSQLException(ex);
        }
    }

    @Override
    public List<CybookAuthor> getAuthors() throws ReaderSQLException {
        List<CybookAuthor> authors = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(GET_AUTHORS_QUERY);
            while(rs.next()){
                authors.add(new CybookAuthor(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        }catch(Exception ex){
            throw new ReaderSQLException(ex);
        }
        return authors;
    }

    /**
     * This will return a list of books that are currently being readed
     * @return
     */
    @Override
    public List<CybookBook> getReadingBooks() throws ReaderSQLException{
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(READING_BOOKS_QUERY);
            return readBooks(rs);
        }catch (Exception e) {
            throw new ReaderSQLException(e);
        }
    }

    @Override
    public List<CybookBook> getBooksByAuthor(CybookAuthor author) throws ReaderSQLException,InvalidArgumentException {
        if(author==null || author.getId()<=0){
            throw new InvalidArgumentException("Invalid author object");
        }
        try{
            Statement st = conn.createStatement();
            String queryString = String.format(GET_BOOKS_BY_AUTHOR_QUERY,author.getId());
            ResultSet rs = st.executeQuery(queryString);
            return readBooks(rs);
        }catch (Exception ex){
            throw new ReaderSQLException(ex);
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
}
