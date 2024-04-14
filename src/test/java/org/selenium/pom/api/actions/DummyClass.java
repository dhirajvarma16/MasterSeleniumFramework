package org.selenium.pom.api.actions;

import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

    public static void main(String[] args) {
        String username="demouser2"+new FakerUtils().generateRandomNumber();
        UserLogin userLogin=new UserLogin()
                .setUsername("username")
                .setPassword("demopwd").
                setEmail(username+"@askomdh.com");
        SignUpApi signUpApi= new SignUpApi();
        System.out.println(signUpApi.register(userLogin));
        System.out.println(signUpApi.getCookie());
    }

}

