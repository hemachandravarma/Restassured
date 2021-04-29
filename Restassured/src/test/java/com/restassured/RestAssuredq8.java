package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredq8 {
	public static void main(String[] args) 
	{
		// take input from the key board 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value for path parameter like id 1 to 100 valid");
		String id=sc.nextLine();
		System.out.println("Enter criteria valid invlid for path parameter like id");
		String Criteria=sc.nextLine();
		sc.close();
		//Register uri of restful service resourcec under testing.
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/" + id;
		//submit request via http  get method. and get response 
		Response res=RestAssured.get();
		//Analyze response status code 
		int code=res.getStatusCode();
		if(Criteria.equalsIgnoreCase("valid")&& code==200) 
		{
			System.out.println("Response status codet test passed with " +code+ "Status code");
			String ct=res.getHeaders().getValue("Content-Type");
			ct.toLowerCase();
			if(ct.contains("json"))
			{
				System.out.println("Body content test passed");
				String aid=res.getBody().jsonPath().getString("id");
				if(id.equals(aid))
				{
					System.out.println("Body content test passd");
				}else 
				{
					System.out.println("Body format test failed because body is not in json frormat");
				}
				
			}
			else 
			{
				System.out.println("Body content test failed");
			}
			
			
		}
		else if(Criteria.equalsIgnoreCase("invalid")&& code==400)
		{
			System.out.println("Response statu code test passedn with" + code + "Status code");
			String ct=res.headers().getValue("Content-Type");
			ct.toLowerCase();
			if(ct.contains("json")) 
			{
				System.out.println("body format test passed because bosy isin json format");
				String aid=res.getBody().jsonPath().getString("id");
				try {
				
				if(aid.isEmpty()) 
				{
					System.out.println("body content test passed because body is empty ");
				}else 
				{
					System.out.println("Body content test failed with"+ code);
				}
			}
				catch(Exception ex) 
				 {
					System.out.println(ex);
				 }
				}
			else 
			{
				System.out.println("Body content test failed because bosy is not in json format");
			}
		}
		else 
		{
			System.out.println("http get method test failed" + code);
		}
	}
	
}
		
		
