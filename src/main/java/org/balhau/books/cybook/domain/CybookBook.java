package org.balhau.books.cybook.domain;

import org.balhau.books.domain.Ebook;

import java.util.Date;

/**
 *
 * Created by vitorfernandes on 10/9/16.
 */
public class CybookBook extends Ebook{
    private final int bookID;
    private final String bookURI;
    private final int pages;
    private final int currpage;
    private final Date lastread;
    private final Date publicationDate;
    private final String publisher;

    public CybookBook(
            int bookID,String bookURI,int pages,int currpage,Date lastread,
            Date publicationDate,String publisher,String author,String title,
            String description
    ){
        super(title,description,author);
        this.bookID=bookID;this.bookURI=bookURI;
        this.pages=pages;this.currpage=currpage;
        this.lastread=lastread;this.publicationDate=publicationDate;
        this.publisher=publisher;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookURI() {
        return bookURI;
    }

    public int getPages() {
        return pages;
    }

    public int getCurrpage() {
        return currpage;
    }

    public Date getLastread() {
        return lastread;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
