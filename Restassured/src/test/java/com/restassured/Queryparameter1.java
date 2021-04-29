package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Queryparameter1 
{

	public static void main(String[] args) 
	{
		//take input from the keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a path paraameter like full country name");
		String country=sc.nextLine();
		System.out.println("Enter a completeness sentense true /false ");
		String status=sc.nextLine();
		sc.close();
		// Register a restful service resource under testing
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name/" + country;
		//send request for getting response 
		Response res=RestAssured.given().queryParam("Fulltext", status).get();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
	}

}
