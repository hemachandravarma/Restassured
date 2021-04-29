package com.restassured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredunnamedjsonresponse {

	public static void main(String[] args) {
		// Register a restful service resource under testing
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		//submit request and get response via http get()
		Response res=RestAssured.get();
		
		//analyze response
		int code=res.getStatusCode();
		System.out.println("Status code test passed wit " + code);
		
		//get first record id
		String fr=res.getBody().jsonPath().getString("[0].id");
		System.out.println(fr);
		
		//get last record from the response 
		
		String lr=res.getBody().jsonPath().getString("[-1].id");
		System.out.println(lr);
		
		//get all id's of unnamed blocks
		List<Integer> all=res.getBody().jsonPath().getList("id");
		for(int i=0;i<all.size();i++)
		{
			System.out.println(all.get(i));
		}
		
		//get all maps from the un named blocks 
		
		List<Map<String, Object>> allm=res.getBody().jsonPath().getList(".");
		
		//get the first map from the list of maps 
		Map<String, Object> fm=allm.get(0);
		System.out.println("first block");
		System.out.println("-----------");
		for(Map.Entry<String, Object> me:fm.entrySet())
		{
			System.out.println(me.getKey() + "" +me.getValue());
		}
		
		//get the last map from the list of maps 
		
		Map<String, Object> lm=res.getBody().jsonPath().getMap("[99]");
		System.out.println("last map");
		System.out.println("--------");
		
		for(Map.Entry<String, Object> le: lm.entrySet()) 
		{
			System.out.println(le.getKey()+ "" + le.getValue());
		}
	}

}
