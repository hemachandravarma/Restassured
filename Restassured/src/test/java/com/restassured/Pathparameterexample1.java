package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pathparameterexample1 {

	public static void main(String[] args) {
		//1. take input from the keyboard 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value like id from 1-100");
		String x=sc.nextLine();
		System.out.println("Enter criteria valid or invalid");
		String ct=sc.nextLine();
		sc.close();
		
		//2. Register a restful service resource under testing 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/"+x;
		
		//3. send the request for getting response using get() method
		Response res=RestAssured.get();
		
		//System.out.println(res.getStatusCode());
		//System.out.println(res.getContentTypr());
		//System.out.prinln(res.getBody().asString());
		 
		//4.Status code
		//4.1 analyze the response
		int code=res.getStatusCode();
		
		if(ct.equalsIgnoreCase("valid") && code==200) 
		{
			System.out.println("Status code test passed with" + code);
			String contype=res.getHeaders().getValue("Content-type");
			contype.toLowerCase();
				if(contype.contains("json"))
				{
					System.out.println("body format test passed because body is in json format");
				}
					else 
						{
							System.out.println("body format test failed because body is not in json format");
						}
			
			String y=res.getBody().jsonPath().getString("id");
			if(x.equals(y)) 
				{
					System.out.println("Body content test passed");
				}
				else {
						System.out.println("Body content test failed");
						}
		}
		else if(ct.equalsIgnoreCase("invalid") && code==400) 
			{
				System.out.println("Status code test passed with" + code);
				String ctype=res.getHeaders().getValue("Content-type");
				ctype.toLowerCase();
				
				
				if(ctype.contains("json"))
					{
					System.out.println("Body content test passed because body is in json format");
					
					try 
					{
						String jid=res.getBody().jsonPath().getString("id");
						if(jid.isEmpty()) 
						{
							System.out.println("Body content test passed because body is empty");	
						} else
						{
							System.out.println("body content test failed" + jid);
							}
						}
					catch(NullPointerException ne) 
					{
						System.out.println("Body content test passed bcaause body is empty");
					}
				}
				
				else
				{
					System.out.println("Body content test failed because body is not in json format");
				}		
			}
		else {
			System.out.println("Http getmethod failed");
		}
	}
}
