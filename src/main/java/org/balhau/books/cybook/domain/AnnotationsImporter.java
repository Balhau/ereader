package org.balhau.books.cybook.domain;

import java.util.Map;

/**
 * Created by vitorfernandes on 10/9/16.
 */
public interface AnnotationsImporter {
    Map<String,CybookAnnotation> getBooksAnnotations();
}
