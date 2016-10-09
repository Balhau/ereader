package com.balhau.books.cybook

import org.balhau.books.cybook.importer.annotations.CybookAnnotationsImporter
import spock.lang.Specification

/**
 * Created by vitorfernandes on 10/8/16.
 */
class CybookAnnotationsImporterTest extends Specification{

    private CybookAnnotationsImporter victim;

    def setup(){
        def rootPath=this.getClass().getClassLoader().getResource("cybook/annotations").path
        victim=new CybookAnnotationsImporter(rootPath)
    }

    def "Test annotation loading"(){
        def bookAnnotations;
        when:
        bookAnnotations=victim.getBookAnnotations()
        then:
        bookAnnotations.size()>0
    }
}
