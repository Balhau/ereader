package org.balhau.books.cybook;

import org.balhau.books.cybook.domain.AnnotationsImporter;
import org.balhau.books.cybook.domain.CybookAnnotation;
import org.balhau.books.cybook.domain.CybookBook;
import org.balhau.books.cybook.domain.SQLImporter;
import org.balhau.books.domain.ReaderSQLException;

import java.util.*;
import java.util.stream.Collectors;


public class CybookAPI {
    private AnnotationsImporter annotationsImporter;
    private SQLImporter sqlImporter;

    public CybookAPI(AnnotationsImporter annotationsImporter,SQLImporter sqlImporter){
        this.annotationsImporter=annotationsImporter;
        this.sqlImporter=sqlImporter;
    }

    public List<CybookBook> getOnlyBooksWithAnnotations() throws ReaderSQLException{
        List<CybookBook> booksWithAnnotations=getReadedBooksWithAnnotations();
        return booksWithAnnotations.stream()
                .filter(book -> book.getAnnotations().isPresent())
                .collect(Collectors.toList());
    }

    public List<CybookBook> getReadedBooksWithAnnotations() throws ReaderSQLException{
        List<CybookBook> readingBooks = this.sqlImporter.getReadingBooks();
        List<CybookBook> readingBooksWithAnnotations=new ArrayList<>(readingBooks.size());
        Map<String,CybookAnnotation> annotationMap = this.annotationsImporter.getBooksAnnotations();
        CybookAnnotation annotations;
        Set<String> keys = annotationMap.keySet();
        for(CybookBook book : readingBooks){
            annotations=annotationMap.get(getPossibleKey(keys,book.getBookURI()));
            readingBooksWithAnnotations.add(
                    new CybookBook.Builder(book)
                    .Annotations(Optional.ofNullable(annotations))
                    .build()
            );
        }
        return readingBooksWithAnnotations;
    }

    private String getPossibleKey(Set<String> keys,String possibleKey){
        String[] splitedKey = possibleKey.split("/");
        String strippedKey = splitedKey[splitedKey.length-1];
        for(String k : keys){
            if(k.contains(strippedKey)){
                return k;
            }
        }
        return "";
    }
}
