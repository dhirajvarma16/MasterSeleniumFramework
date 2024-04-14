package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CartApi {
    private Cookies cookies;

    public CartApi(Cookies cookies){
        this.cookies = cookies;
    }

    public CartApi() {
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCart(int productId,int quantity){
        {
            Cookies cookie= new Cookies();
            Header header= new Header("Content-Type","application/x-www-form-urlencoded");
            Headers headers= new Headers(header);
            HashMap<String,Object> formParams= new HashMap<>();
            formParams.put("product_sku", "");
            formParams.put("product_id",productId);
            formParams.put("quantity",quantity);

            if (cookies==null){
                cookie= new Cookies();
            }

            Response response=
                    given()
                            .baseUri(ConfigLoader.getConfigLoader().getBaseUrl()).
                            headers(headers).
                            formParams(formParams).
                            cookies(cookie).
                            log().all().
                    when().
                            post("/?wc-ajax=add_to_cart").
                    then().
                            log().all().
                            extract().response();
            if (response.statusCode()!=200) {
                throw new RuntimeException(" ");
            }
            this.cookies = response.getDetailedCookies();
            return response;
        }

    }
}
