package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RhpBasicauthentication {

	public static void main(String[] args) 
	{
		// Register a restful service resource under testing 
		RestAssured.baseURI="https://the-internet.herokuapp.com/basic_auth";
		
		//create and submit the response using http method 
		Response res=RestAssured.given()
								.auth()
								.basic("admin", "admin")
								.get();
		//print the response from the server
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	
	}

}
