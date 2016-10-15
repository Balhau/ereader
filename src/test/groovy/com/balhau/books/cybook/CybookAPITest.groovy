package com.balhau.books.cybook

import org.balhau.books.cybook.CybookAPI
import org.balhau.books.cybook.domain.CybookAuthor
import org.balhau.books.cybook.domain.CybookBook
import org.balhau.books.cybook.importer.annotations.CybookAnnotationsImporter
import org.balhau.books.cybook.importer.sqlite.SQLiteImporter
import spock.lang.Specification

/**
 * Created by vitorfernandes on 10/9/16.
 */
class CybookAPITest extends Specification{

    private annotationRootPath=this.getClass().getClassLoader().getResource("cybook/annotations").path
    private sqlitePath=this.getClass().getClassLoader().getResource("cybook/system/library").path
    private victim
    private annotationImporter
    private sqlImporter

    def setup(){
        annotationImporter = new CybookAnnotationsImporter(annotationRootPath)
        sqlImporter = new SQLiteImporter(sqlitePath)
        victim = new CybookAPI(annotationImporter,sqlImporter)
    }

    def "Get all reading books with annotations if presented"(){
        when:
            List<CybookBook> readingBooksWithAnnotations = victim.getReadedBooksWithAnnotationsIfPresent()
        then:
            readingBooksWithAnnotations.size()>100
            CybookBook b = readingBooksWithAnnotations.get(0)
            b.annotations.isPresent() == false
    }

    def "Get only those books with annotations"(){
        when:
            List<CybookBook> readingBooksOnlyWithAnnotations=victim.getOnlyBooksWithAnnotations()
        then:
            readingBooksOnlyWithAnnotations.size()>0 && readingBooksOnlyWithAnnotations.size()<10
            CybookBook b = readingBooksOnlyWithAnnotations.get(0)
            b.annotations.isPresent() == true
            b.annotations.get().getAnnotation().size()>0
            b.annotations.get().getAnnotation().get(0) != ""
    }


    def "Get author list"(){
        when:
            List<CybookAuthor> authors = victim.getAuthors()
        then:
            authors.size()>0
            authors.get(0).getId() > 0
            authors.get(0).getName() != null
    }


    def "Get books by author"(){
        when:
            List<CybookAuthor> authors = victim.getAuthors()
            List<CybookBook> booksByAuthor = victim.getBooksByAuthor(authors.get(1))
        then:
            authors.size() > 0
            booksByAuthor.size() > 0
    }


}
