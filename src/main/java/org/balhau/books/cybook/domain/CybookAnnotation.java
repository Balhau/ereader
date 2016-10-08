package org.balhau.books.cybook.domain;

import org.balhau.books.domain.BookAnnotation;

import java.util.List;

/** Domain object for a cybook set of annotations
 * Created by vitorfernandes on 10/8/16.
 */
public class CybookAnnotation extends BookAnnotation{
    private final String book;
    private final List<String> annotation;

    public CybookAnnotation(String book,List<String> annotations){
        this.book=book;
        this.annotation=annotations;
    }

    public String getBook() {
        return book;
    }

    public List<String> getAnnotation() {
        return annotation;
    }
}
