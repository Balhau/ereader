package com.balhau.books.cybook

import org.balhau.books.cybook.domain.CybookBook
import org.balhau.books.cybook.importer.sqlite.SQLiteImporter
import spock.lang.Specification

import java.sql.SQLClientInfoException

/**
 * Created by vitorfernandes on 10/9/16.
 */
class SQLiteImporterTest extends Specification{
    private sqlitePath=this.getClass().getClassLoader().getResource("cybook/system/library").path
    private victim

    def setup(){
        victim=new SQLiteImporter(sqlitePath)
    }

    def "Get reading books"(){
        when:
            List<CybookBook> readingbooks = victim.getReadingBooks()
        then:
            readingbooks.size()>0
            CybookBook b = readingbooks.get(0)
            b.getBookID() != 0
            b.getDescription() == ""
            b.getAuthor() != ""
            b.getTitle() != ""
            b.toJSON() != ""
    }
}
