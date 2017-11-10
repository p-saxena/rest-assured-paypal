package com.paypalexamples.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

/**
 * Created by watchmaster on 9/22/17.
 */
public class BaseClass {

    public	static String accessToken;

    //PUT YOUR CLIENT ID & CLIENT SECRET HERE
    public static final String  clientId="AR41Lik4cGYO6pbkIEzhKj1vekRqSe0KE2LYrbuO8k7bbWt9HlE-TuRSY1k97SSXzkTCO6p24Wo83461";
    public static  final String  clientSecret="EBrk7FtQ_Ybepr7icjT9cS06Svp8yz08KgdPCoRdleyxXit6YPisQiFm72LWgfk8AHTt1x63z2vzZoKI";

    /**
     * use access token from init method in all tests
     */
    @BeforeClass
    public static void init(){

        RestAssured.baseURI="https://api.sandbox.paypal.com";
        RestAssured.basePath="/v1";

        accessToken=	given()
                .parameters("grant_type","client_credentials")
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .when()
                .post("/oauth2/token")
                .then()
                .extract()
                .path("access_token");
        System.out.println("The token is: "+accessToken);
    }
}
