package org.balhau.books.cybook.domain;

import org.balhau.books.domain.BookAnnotation;

import java.util.List;

/** Domain object for a cybook set of annotations
 * Created by vitorfernandes on 10/8/16.
 */
public class CybookAnnotation extends BookAnnotation{
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
