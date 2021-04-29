package com.restassured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Jsonpathexpression {

	public static void main(String[] args) {
		//1. Register a restful service resource under testing.
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/";
		
		//2. Send request to get the response 
		Response res=RestAssured.get();
		
		//3. Get Status code 
		//System.out.println(res.getStatusCode());
		int x=res.getStatusCode();
		if (x==200) 
		{
			System.out.println(" Status code test passed with " + x);
		}else
		{
			System.out.println(" Status code test failed with " + x);
		}
		
		//4.get the first "id" post value
		String firstid=res.getBody().jsonPath().getString("id[0]");
		System.out.println(firstid);
		if (firstid.equalsIgnoreCase("1"))
		{
			System.out.println("First block id test passed");
		}
		else
		{
			System.out.println("First block test filed");
		}
		//5.get the last id value of a post 
		String lastid=res.getBody().jsonPath().getString("id[-1]");
		System.out.println(lastid);
		if (lastid.equalsIgnoreCase("100"))
		{
			System.out.println("last block id test passed");
		}
		else
		{
			System.out.println("last block test filed");
		}
		
		//6.get the id values in all posts
		List<Object> s=res.getBody().jsonPath().getList("id");
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
		//7. use "." as a root to collect all the blocks when there is no name to root 
		List<Map<String, Object>> all=res.getBody().jsonPath().getList(".");
		
		//8. get the first block entry
		Map<String, Object> fb=all.get(0);
		System.out.println("first block");
		System.out.println("-----------");
		for(Map.Entry<String, Object> so: fb.entrySet())
		{
			System.out.println(so.getKey() + "" + so.getValue());
		}
		
	
		//9.get the last block entry
		Map<String, Object> lb= all.get(all.size()-1);
		System.out.println("Last block");
		System.out.println("------------");
		for(Map.Entry<String, Object> eso: lb.entrySet())
		{
			System.out.println(eso.getKey() + " " + eso.getValue());
		}
		
	}

}
