package org.balhau.books.cybook.importer.sqlite;

import org.balhau.books.cybook.domain.CybookBook;
import org.balhau.books.cybook.domain.SQLImporter;
import org.balhau.books.domain.ReaderSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.balhau.books.utils.SqliteUtils.*;
/**
 * This implementation retrieve meaningful data from SQLite database presented in Cybook devices
 */
public class SQLiteImporter implements SQLImporter{

    //Queries
    private static final String READING_BOOKS_QUERY="select\n" +
            "  f_id_item, f_pages_number, f_current_page, f_last_read,\n" +
            "  f_publication_date,f_publisher,f_title,f_description,\n" +
            "  f_internal_uri,f_name,f_islastpage,f_documenttime\n" +
            "   from T_ITEM as I INNER JOIN T_AUTHOR as A\n" +
            "where I.f_current_page != -1 and I.f_author_id==A.f_id_author;";

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

    /**
     * This will return a list of books that are currently being readed
     * @return
     */
    @Override
    public List<CybookBook> getReadingBooks() throws ReaderSQLException{
        try{
            List<CybookBook> books=new ArrayList<>();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(READING_BOOKS_QUERY);
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
        }catch (Exception e) {
            throw new ReaderSQLException(e);
        }
    }
}
