package org.balhau.books.cybook.importer.annotations;

import org.balhau.books.cybook.domain.AnnotationsImporter;
import org.balhau.books.cybook.domain.CybookAnnotation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation that retrieve annotations from the cybook data sources
 */
public class CybookAnnotationsImporter implements AnnotationsImporter{

    private final String rootPath;
    private final DocumentBuilderFactory dbFactory;
    private static final String TARGET_NODE="target";
    private static final String TEXT_NODE="text";

    public CybookAnnotationsImporter(String rootPath){
        this.rootPath=rootPath;
        this.dbFactory = DocumentBuilderFactory.newInstance();
    }

    @Override
    public Map<String,CybookAnnotation> getBooksAnnotations() {

        Map<String,CybookAnnotation> annotations = new HashMap<>();
        File annotationFile = new File(rootPath);
        File[] bookDirectories=annotationFile.listFiles();
        File bookFile;
        CybookAnnotation annotation;
        for(File directory : bookDirectories){
            bookFile=directory.listFiles()[0];
            annotation=parseFile(bookFile);
            annotations.put(annotation.getBookURI(),annotation);
        }

        return annotations;
    }

    private CybookAnnotation parseFile(File bookFile) {
        List<String> aList = new ArrayList<>();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(bookFile);
            NodeList nodes = doc.getElementsByTagName(TARGET_NODE);
            Node node;
            Element aux;
            for (int i = 0; i < nodes.getLength(); i++) {
                try {
                    node = nodes.item(i);
                    aux = (Element) ((Element) node).getElementsByTagName(TEXT_NODE).item(0);
                    aList.add(aux.getTextContent());
                }catch (Exception ex){}
            }
        }catch(Exception ex){}

        return new CybookAnnotation(bookFile.getPath(),aList);
    }
}
