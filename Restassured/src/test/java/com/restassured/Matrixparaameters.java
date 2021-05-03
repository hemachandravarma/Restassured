package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Matrixparaameters {

	public static void main(String[] args) {
	//Register a restful service resource under testing.
	RestAssured.urlEncodingEnabled=false; //because there is no alternative method for
	//matrix parameter in rest assured
	//RestAssured.baseURI="https://petstore.swagger.io/v2/p2/findByStatus;matrixparam=text";
	RestAssured.baseURI="https://www.info.com/vijayawadda";
	Response res=RestAssured.given().queryParam("Offset", "0")
									.queryParam("pagenunber", "0").get();
	//print the response 
	System.out.println(res.getStatusLine());
	System.out.println(res.getContentType());
	System.out.println(res.getBody().asString());
	}

}
