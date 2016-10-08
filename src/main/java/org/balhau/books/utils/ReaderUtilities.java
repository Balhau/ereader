package org.balhau.books.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by vitorfernandes on 10/8/16.
 */
public class ReaderUtilities {


    public static Properties getProperties(InputStream stream){
    try{
        //load a properties file from class path, inside static method
        if(stream==null){
            return null;
        }
        Properties prop = new Properties();
        prop.load(stream);
        return prop;
    } catch (IOException ex) {
    } finally{
        if(stream!=null){
            try {
                stream.close();
            } catch (IOException e) {

            }
        }
    }
    return null;
    }
}
