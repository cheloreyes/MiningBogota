package com.chelo.reyes;

import javax.naming.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cheloreyes on 15/04/17.
 */
public class Utilities {
    private static String PROPERTIES = "config.properties";
    private static String RPI_1 = "RpiUno";
    private static String RPI_2 = "RpiDos";
    private static String RPI_3 = "RpiTres";


    public Utilities() {
    }

    public static Properties getProperties(Class klass){
        Properties prop = new Properties();
        try {
            InputStream input = klass.getClassLoader().getResourceAsStream(PROPERTIES);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
