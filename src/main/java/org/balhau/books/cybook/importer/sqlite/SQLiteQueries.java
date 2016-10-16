package org.balhau.books.cybook.importer.sqlite;

/**
 * This is a dictionary for a bunch of sql queries
 * Created by vitorfernandes on 10/15/16.
 */
public class SQLiteQueries {
    /**
     * Query that will retrieve all the books that are currently being read
     */
    public static final String READING_BOOKS_QUERY = "select\n" +
            "  f_id_item, f_pages_number, f_current_page, f_last_read,\n" +
            "  f_publication_date,f_publisher,f_title,f_description,\n" +
            "  f_internal_uri,f_name,f_islastpage,f_documenttime\n" +
            "   from T_ITEM as I INNER JOIN T_AUTHOR as A\n" +
            "where I.f_current_page != -1 and I.f_author_id==A.f_id_author;";

    /**
     * Query that will retrieve the list of authors
     */
    public static final String GET_AUTHORS_QUERY = "select f_id_author,f_name from T_AUTHOR;";

    /**
     * Query that will return the books by author id
     */
    public static final String GET_BOOKS_BY_AUTHOR_QUERY = "select\n" +
            "  f_id_item, f_pages_number, f_current_page, f_last_read,\n" +
            "  f_publication_date,f_publisher,f_title,f_description,\n" +
            "  f_internal_uri,f_name,f_islastpage,f_documenttime\n" +
            "from T_ITEM as I INNER JOIN T_AUTHOR as A\n" +
            "where I.f_current_page != -1 and I.f_author_id==A.f_id_author and A.f_id_author = %d;";

    public static final String GET_ALL_BOOKS_QUERY = "select\n" +
            "  f_id_item, f_pages_number, f_current_page, f_last_read,\n" +
            "  f_publication_date,f_publisher,f_title,f_description,\n" +
            "  f_internal_uri,f_name,f_islastpage,f_documenttime\n" +
            "   from T_ITEM as I INNER JOIN T_AUTHOR as A\n" +
            "where I.f_author_id==A.f_id_author;";

}
