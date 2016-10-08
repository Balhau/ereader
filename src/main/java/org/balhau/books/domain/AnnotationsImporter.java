package org.balhau.books.domain;

import org.balhau.books.domain.BookAnnotation;

import java.util.List;

/**
 * This is the contract that annotations importer should implement
 * Created by vitorfernandes on 10/8/16.
 */
public interface AnnotationsImporter {
    List<BookAnnotation> getBookAnnotations();
}
