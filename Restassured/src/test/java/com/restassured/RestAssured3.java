package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class RestAssured3 {

	public static void main(String[] args)
	{
		// Take input from the key board
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the path parameter like full country code like full country name");
		String fcn=sc.nextLine();
		System.out.println("Enter comlete status(true/false) of a given country name");
		String status=sc.nextLine();
		sc.close();
		//Register rest api with with query parameters 
		RestAssured.baseURI="https://restcountries.eu/rest/v2/alpha/"+fcn;
		Response res=RestAssured.given().queryParam("full text", status).get();
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
	

	}

}
