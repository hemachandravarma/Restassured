package com.restassured;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredNamedblocksresponse {

	public static void main(String[] args) {
		// Register a Restful service resource under testing 
		RestAssured.baseURI="https://api.weatherapi.com/v1/current.json";
		
		//submit response via http get method 
		Response res=RestAssured.given()
								.queryParam("Key", "e9c3b0195be341c795281747202311")
								.queryParam("q","vijayawada").get();
		
		//Get Status code 
		int code=res.getStatusCode();
		System.out.println(code);
		
		//get all get specific value 
		String x=res.getBody().jsonPath().getString("location.localtime");
		System.out.println(x);
		
		String y=res.getBody().jsonPath().getString("current.condition.text");
		System.out.println(y);
		
		//get a block of data (go to specific named block using Gpath expression )
		System.out.println("first block");
		System.out.println("-----------");
		Map<String, Object> fb=res.getBody().jsonPath().getMap("location");
		for(Map.Entry<String, Object> md: fb.entrySet()) 
		{
			System.out.println(md.getKey() + " " + md.getValue());
		}
		
		//get block of data (got to specific named block using Gpath Expression)
		System.out.println("Current block");
		System.out.println("-------------");
		Map<String , Object> lb=res.getBody().jsonPath().getMap("current");
		for(Map.Entry<String, Object> ld: lb.entrySet())
		{
			System.out.println(ld.getKey()+ "" + ld.getValue());
		}
		
		//get block of data (Got to Specific named blobk using gpath expression)
		System.out.println("Condition block");
		System.out.println("---------------");
		Map<String , Object> cb=res.getBody().jsonPath().getMap("current.condition");
		for(Map.Entry<String, Object> cbl: cb.entrySet()) 
		{
			System.out.println(cbl.getKey() + "" + cbl.getValue());
		}
	}

}
