package com.restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparaameters 
{

	public static void main(String[] args) 
	{
		// Register a URI of restful service 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/";
		//Add Json-Java dependency code for send request in JSON format
		//Java Json can provide classes to pack java data to json formatted data
		//packing(Serialization)request body parameters in json format 
		JSONObject js=new JSONObject();
		js.put("UserId",11);
		js.put("id", 101);
		js.put("Title","Badkov");
		js.put("Body", " Hi all Badkows Sreedhar, punam, DCM lorry, lab assistent, aanand");
		//create and submit HTTP request with body parameters via post method
		
		Response res=RestAssured.given().header("Content-Type","Application/json")
										.body(js.toString())
										.post();
		System.out.println("Posted successful with"+  res.getStatusCode());
		//print the response 
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
		//get the added request 
		Response res2=RestAssured.get();
		
		String lastid=res2.getBody().jsonPath().getString("id[0]");
		System.out.println(lastid);
		
		
	}

}