package org.balhau.books.cybook;

import com.sun.corba.se.impl.protocol.RequestCanceledException;
import org.balhau.books.cybook.domain.*;
import org.balhau.books.domain.exceptions.InvalidArgumentException;
import org.balhau.books.domain.exceptions.ReaderSQLException;

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
        List<CybookBook> booksWithAnnotations=getReadedBooksWithAnnotationsIfPresent();
        return booksWithAnnotations.stream()
                .filter(book -> book.getAnnotations().isPresent())
                .collect(Collectors.toList());
    }

    public List<CybookAuthor> getAuthors() throws ReaderSQLException {
        return this.sqlImporter.getAuthors();
    }

    public List<CybookBook> getReadedBooksWithAnnotationsIfPresent() throws ReaderSQLException{
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

    public List<CybookBook> getBooksByAuthor(CybookAuthor author) throws ReaderSQLException,InvalidArgumentException {
        return this.sqlImporter.getBooksByAuthor(author);
    }

    public List<CybookBook> getBooks() throws ReaderSQLException {
        return this.sqlImporter.getBooks();
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
