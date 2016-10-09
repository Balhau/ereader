package com.balhau.books.cybook

import org.balhau.books.cybook.domain.CybookBook
import org.balhau.books.cybook.importer.sqlite.SQLiteImporter
import spock.lang.Specification

/**
 * Created by vitorfernandes on 10/9/16.
 */
class CybookSQLImporterTest extends Specification{

    private SQLiteImporter victim;

    def setup(){
        def sqlitPath=this.getClass().getClassLoader().getResource("cybook/system/library").path
        victim=new SQLiteImporter(sqlitPath)
    }

    def "Get reading books"(){
        when:
            List<CybookBook> readingbooks = victim.getReadingBooks()
        then:
            readingbooks.size()>0
    }
}
