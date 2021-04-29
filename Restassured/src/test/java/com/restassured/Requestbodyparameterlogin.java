package com.restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparameterlogin {

	public static void main(String[] args) 
	{
		// register a restful service resource under testing
		RestAssured.baseURI="https://reqres.in/api/login";
		
		//Pack(Serialize) the request body parameter with values 
		JSONObject js=new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		//Create and submit the request via http methods
		
		Response res=RestAssured.given()
								.header("Content-Type","application/json")
								.body(js.toString())
								.post();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
		String x=res.getBody().jsonPath().getString("token");
		System.out.println("Genarated tokens is" + x);	
		
	}

}
