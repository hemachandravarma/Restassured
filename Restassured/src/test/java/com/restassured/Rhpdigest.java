package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rhpdigest {

	public static void main(String[] args) 
	{
		// Register a restful service resource under testing 
		RestAssured.baseURI="https://the-internet.herokuapp.com/basic_auth";
		 
		//Create and submit http request with basic authentication via get method 
	Response res=RestAssured.given().auth().digest("admin","admin").get();
	
	//print the response 
	
	System.out.println(res.getStatusLine());
	System.out.println(res.getContentType());
	System.out.println(res.getBody().asString());

	}

}
