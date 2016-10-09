package org.balhau.books.domain;

/**
 * Base container for ebooks
 * Created by vitorfernandes on 10/9/16.
 */
public abstract class Ebook {
    protected final String title;
    protected final String description;
    protected final String author;

    public Ebook(String title,String description,String author){
        this.author=author;
        this.description=description;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}
