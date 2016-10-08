package com.balhau.books;

import spock.lang.*

class UtilsTest extends Specification {

    private loaderFolder;

    def setup() {
        this.loaderFolder="loadertest";
    }

    def "Test directory loading"() {
        when:
            def f = new File(this.getClass().getClassLoader().getResource(loaderFolder).path)
            def children = f.listFiles()
        then:
            children.size() == 2
    }
}
