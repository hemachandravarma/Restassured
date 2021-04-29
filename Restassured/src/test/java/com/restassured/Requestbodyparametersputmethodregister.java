package com.restassured;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Requestbodyparametersputmethodregister {

	public static void main(String[] args) {
		// register restful service resource under test
		RestAssured.baseURI="https://reqres.in/api/users";
		//Serialize request body  parameters with values in json format
		JSONObject js=new JSONObject();
		js.put("Name", "Pixar");
		js.put("Job", "Animation");
		
		//send request via using post method 
		
		Response res =RestAssured.given()
								.header("Content-Type", "Application/json")
								.body(js.toString()).post();
	
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
		String getjob=res.getBody().jsonPath().getString("Job");
		
		System.out.println("job title :" +getjob);
		
		String getname=res.getBody().jsonPath().getString("name");
		System.out.println("name :" + getname);
		
		int getid=res.getBody().jsonPath().getInt("id");
		System.out.println("id of the block:" + getid);
		
		String gedcreatedat=res.getBody().jsonPath().getString("createdAt");
		System.out.println("Created date and time:" + gedcreatedat);
	}

}
