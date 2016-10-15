package com.balhau.books

import org.balhau.books.utils.ReaderUtilities;
import spock.lang.*

class UtilsTest extends Specification {

    private loaderFolder;

    def setup() {
        this.loaderFolder="loadertest";
    }

    def "Test directory loading"() {
        File f
        File[] children
        when:
            f = new File(this.getClass().getClassLoader().getResource(loaderFolder).path)
            children = f.listFiles()
        then:
            children.size() == 2
    }

    def "Test reader utilities getProperties"(){
        File f
        File[] children
        when:
            f = new File(this.getClass().getClassLoader().getResource(loaderFolder).path)
            children = f.listFiles()
            Properties props1 = ReaderUtilities.getProperties(new FileInputStream(children[0].getAbsolutePath()))
            Properties propsNull1 = ReaderUtilities.getProperties(null)
        then:
            props1.size() == 1
            propsNull1 == null
    }
}
