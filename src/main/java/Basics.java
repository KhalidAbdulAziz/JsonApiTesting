import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Basics {

    //public static void main (String [] args){

    @Test
    public void Test() {

        RestAssured.baseURI = "https://maps.googleapis.com";

        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "1500").
                param("type", "restaurant").
                param("keyword", "cruise").
                param("key", "AIzaSyDakDGisLBNRhe0AQf8r34ptDYrd2BKycQ").
                when().
                get("maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                body("results[0].place_id", equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).
                body("results[0].name", equalTo("Cruise Bar"));

        System.out.println("Hi! Java Assurred api automation");


    }
}







