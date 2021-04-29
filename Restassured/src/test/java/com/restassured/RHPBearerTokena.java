package com.restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RHPBearerTokena {

	public static void main(String[] args) 
	{
		//Bearer token authentication or HMAC Authentication
		//Register a restful service under test
		RestAssured.baseURI="https://reqres.in/api/login";
		//packing(Serializing) request body parameters with values in json format.
		JSONObject js=new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "Cityslicks");
		
		//create and submit the request to the test full service 
		Response res=RestAssured.given()
								.header("Content-Type", "application/json")
								.body(js.toString())
								.post();
		//Display the response getting from the restful resource 
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asPrettyString());
		
		String x=res.getBody().jsonPath().getString("token");
		System.out.println(x);
		// Use the key to operate the further operations.
		

	}

}
