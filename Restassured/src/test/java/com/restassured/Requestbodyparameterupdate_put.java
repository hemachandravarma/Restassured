package com.restassured;

import java.io.IOException;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparameterupdate_put {

	public static void main(String[] args) throws IOException {
		//register a restful service resource under testing
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//pack(serialize) pack the request body with values
		JSONObject jb=new JSONObject();
		jb.put("name", "paparaayudu");
		jb.put("job","barber");
		jb.put("designation", "Sweeper");
		jb.put("Speciality", "ultimate hair stylist");
		
		//create and submit the request via http put method o update the existing record
		Response res=RestAssured.given()
								.headers("Content-Type","application/json")
								.body(jb.toString())
								.put();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
	}

}
