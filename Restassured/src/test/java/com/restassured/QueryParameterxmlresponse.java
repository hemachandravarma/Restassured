package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParameterxmlresponse 
{

	public static void main(String[] args) 
	{
		// Take input from the key board 
				Scanner sc=new Scanner(System.in);
				String key="e9c3b0195be341c795281747202311";
				System.out.println("Enter a location name");
				String l=sc.nextLine();
				sc.close();
				
				//Register a restful service resource under testing
				RestAssured.baseURI="https://api.weatherapi.com/v1/current.xml";
				//Send request for get the required response
				
				Response res=RestAssured.given().queryParam("Key", key).
												 queryParam("q",l).get();
				System.out.println(res.getStatusLine());
				System.out.println(res.getContentType());
				System.out.println(res.getBody().asString());
	}

}
