package org.selenium.pom.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader()  {
        try {
            this.properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConfigLoader getConfigLoader(){
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
