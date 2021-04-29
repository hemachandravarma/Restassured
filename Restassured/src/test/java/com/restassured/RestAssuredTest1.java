package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTest1 
{

	public static void main(String[] args) 
	{
		//Register restful service resource under testing .
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/";
		//submit request via HTTP method to get response
		Response res=RestAssured.get();
		//Analyze response code 
		//status code
		int code=res.getStatusCode();
		System.out.println(code);
		if(code==200) 
		{
			System.out.println("Http GetMethod test passed");
		}
		else 
		{
			System.out.println("Http Get Method test failed");
		}
		String y=res.getHeaders().getValue("Content-Type");
		System.out.println(y);
		if(y.contains("json")) 
		{
			System.out.println("response code in json format");
		}
		else if(y.contains("html"))
		{
			System.out.println("body in html format");
		}
		else if(y.contains("xml")) 
		{
			System.out.println("body in xml format");
		}else 
		{
			System.out.println("body in plain text format");
		}
		
		String body=res.getBody().asString();
		System.out.println(body);
	}

}
