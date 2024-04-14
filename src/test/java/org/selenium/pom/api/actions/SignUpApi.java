package org.selenium.pom.api.actions;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpApi {
    private Cookies cookie;

    public Cookies getCookie(){
        return cookie;
    }

    public String fetchRegisterNonceValueGroovy(){
        Response response=getAccount();
        return response.htmlPath().getString("**.findAll{ it.@name=='woocommerce-register-nonce'}.@value");
    }

    private String fetchRegisterNonceValueJsoup(){
        Response response= getAccount();
        Document document= Jsoup.parse(response.body().prettyPrint());
        Element element = document.selectFirst("#woocommerce-register-nonce");
        return element.attr("value");
    }

    public Response register(UserLogin userLogin){
        Cookies cookie= new Cookies();
        Header header= new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers= new Headers(header);
        HashMap<String,String> formParams= new HashMap<>();
        formParams.put("username", userLogin.getUsername());
        formParams.put("password",userLogin.getPassword());
        formParams.put("woocommerce-register-nonce",fetchRegisterNonceValueJsoup());
        formParams.put("register","Register");


        Response response=
                given()
                        .baseUri(ConfigLoader.getConfigLoader().getBaseUrl()).
                        headers(headers).
                        formParams(formParams).
                        cookies(cookie).
                        log().all().
                when().
                       post("/account").
                then().
                        log().all().
                        extract().response();
        if (response.statusCode()!=200) {
            throw new RuntimeException(" ");
        }
        this.cookie = response.getDetailedCookies();
        return response;
    }


}
