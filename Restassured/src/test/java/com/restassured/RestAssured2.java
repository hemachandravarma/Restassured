package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured2 
{
	public static void main (String args[]) 
	{
		//Take input from the key board 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value from keyboard ");
		String cc=sc.nextLine();
		sc.close();
		//Register rest assured service with path parameters
		RestAssured.baseURI="https://restcountries.eu/rest/v2/alpha/"+cc;
		//submit request via Http get method 
		Response res=RestAssured.get();
		//Display response 
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
