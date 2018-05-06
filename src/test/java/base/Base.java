package base;

import cucumber.api.java.Before;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {

    @Before
    public void setUp(){
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/config.properties");
            properties.load(input);
            RestAssured.baseURI = properties.getProperty("testurl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
