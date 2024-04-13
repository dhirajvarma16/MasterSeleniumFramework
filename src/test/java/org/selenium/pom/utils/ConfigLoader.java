package org.selenium.pom.utils;

import org.selenium.pom.constants.EnviromentType;

import java.io.IOException;
import java.util.Properties;

import static org.selenium.pom.constants.EnviromentType.STAGE;

public class ConfigLoader {
    private Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader()  {
        try {
            String env= System.setProperty("env",String.valueOf(STAGE));
            switch (EnviromentType.valueOf(env)) {
                case STAGE:
                    this.properties = PropertyUtils.propertyLoader("src/test/resources/stgprod_config.properties");
                    break;
                case PROD:
                    this.properties= PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static ConfigLoader getConfigLoader(){
        if (configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop=properties.getProperty("baseUrl");
        if(prop!=null) return prop;
        else throw new RuntimeException("");
    }public String getUsername(){
        String prop=properties.getProperty("username");
        if(prop!=null) return prop;
        else throw new RuntimeException("");
    }public String getPassword(){
        String prop=properties.getProperty("password");
        if(prop!=null) return prop;
        else throw new RuntimeException("");
    }
}
