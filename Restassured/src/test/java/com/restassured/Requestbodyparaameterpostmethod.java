package com.restassured;


import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparaameterpostmethod {

	public static void main(String[] args)
	{
		// register a restful service resource under test
		
		RestAssured.baseURI="https://reqres.in/api/register";
		
		//Packing (Serializing)request body parameter with values in json format
		
		JSONObject obj=new JSONObject();
		obj.put("email", "eve.holt@reqres.in");
		obj.put("password", "pistol");
		//create and submit request via Http post method 
		
		Response res=RestAssured.given()
								.header("Content-Type", "Application/json")
								.body(obj.toString())
								.post();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
		String x=res.getBody().jsonPath().getString("token");
		System.out.println("token is:"+ x);
		int y=res.getBody().jsonPath().getInt("id");
		System.out.println("id is :" + y);
	}

}
