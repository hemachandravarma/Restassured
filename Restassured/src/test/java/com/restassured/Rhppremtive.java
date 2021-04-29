package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rhppremtive {

	public static void main(String[] args)
	{
		// Register a restful service resource under testing 
		RestAssured.baseURI="https://the-internet.herokuapp.com/basic_auth";
		//Create and submit http request basic authentication via get 
		Response res=RestAssured.given().auth().preemptive().basic("admin", "admin").get();
		
		//create and submit the request and get the response from the resource 
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
		

	}

}
