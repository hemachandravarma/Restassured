package com.restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparameter3 
{

	public static void main(String[] args) 
	{
		//register a restful service resource under test 
		RestAssured.baseURI="https://reqres.in/api/register";
		//packing serialize the request body parameters in json format
		
		JSONObject js=new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		
		//create and submit http request with bosy parameters in post method
		
		Response res=RestAssured.given().header("Content-Type","Application/json")
								.body(js.toString())
								.post();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());

	}

}
