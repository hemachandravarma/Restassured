package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured5 {

	public static void main(String[] args) {
		// get input from key board 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter values for the parameters like full country namea");
		String fcn=sc.nextLine();
		System.out.println("Enert competeness status(valid/invalid) of aa given country name");
		String status=sc.nextLine();
		sc.close();
		//Register URI of restful service resource under testing with path parameter 
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name"+fcn;
		//Submit request via http get method to get the response from the server 
		Response res= RestAssured.given().queryParam("Fulltext", status).get();
		//get the response in JSON format
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
