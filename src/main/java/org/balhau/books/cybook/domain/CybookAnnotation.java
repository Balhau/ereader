package org.balhau.books.cybook.domain;

import org.balhau.books.domain.WithSerialization;

import java.util.List;

/** 
 * Domain object for a Cybook set of annotations
 */
public class CybookAnnotation implements WithSerialization{
    private final String bookURI;
    private final List<String> annotation;

    public CybookAnnotation(String bookURI,List<String> annotations){
        this.bookURI=bookURI;
        this.annotation=annotations;
    }

    public String getBookURI() {
        return bookURI;
    }

    public List<String> getAnnotation() {
        return annotation;
    }
}
