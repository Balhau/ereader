package org.balhau.books.cybook.domain;

import org.balhau.books.domain.Ebook;

import java.util.Date;

/**
 *
 * Created by vitorfernandes on 10/9/16.
 */
public class CybookBook extends Ebook{

    public static class Builder{
        private String author;
        private String title;
        private String description;
        private boolean readed;
        private int bookID;
        private String bookURI;
        private int pages;
        private int currpage;
        private Date lastread;
        private String publicationDate;
        private String publisher;

        public Builder(){}

        public Builder Author(String author){
            this.author=author;
            return this;
        }

        public Builder Title(String title){this.title=title;return this;}
        public Builder Description(String description){this.description=description;return this;}
        public Builder IsReaded(boolean readed){this.readed=readed;return this;}
        public Builder BookId(int bookid){this.bookID=bookid;return this;}
        public Builder BookURI(String bookURI){this.bookURI=bookURI;return this;}
        public Builder Pages(int pages){this.pages=pages;return this;}
        public Builder CurrentPage(int page){this.currpage=page;return this;}
        public Builder LastRead(Date lastread){this.lastread=lastread;return this;}
        public Builder PublicationDate(String publicationDate){this.publicationDate=publicationDate;return this;}
        public Builder Publisher(String publisher){this.publisher=publisher;return this;}

        public CybookBook build(){
            return new CybookBook(
                bookID,bookURI,pages,currpage,lastread,
                publicationDate,publisher,author,title,
                description,readed
            );
        }
    }

    private final boolean readed;
    private final int bookID;
    private final String bookURI;
    private final int pages;
    private final int currpage;
    private final Date lastread;
    private final String publicationDate;
    private final String publisher;

    public CybookBook(
            int bookID,String bookURI,int pages,int currpage,Date lastread,
            String publicationDate,String publisher,String author,String title,
            String description,boolean readed
    ){
        super(title,description,author);
        this.bookID=bookID;this.bookURI=bookURI;
        this.pages=pages;this.currpage=currpage;
        this.lastread=lastread;this.publicationDate=publicationDate;
        this.publisher=publisher;
        this.readed=readed;
    }

    public int getBookID() {
        return bookID;
    }

    public boolean isReaded(){
        return readed;
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

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
