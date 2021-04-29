package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Restassured6 {

	public static void main(String[] args) {
		// take input from the key board 
		Scanner sc=new Scanner(System.in);
		String k="e9c3b0195be341c795281747202311";
		System.out.println("Enter location ");
		String l=sc.nextLine();
		
		sc.close();
		//register uri 
		RestAssured.baseURI="https://api.weatherapi.com/v1/current.json";
		Response res=RestAssured.given()
										.queryParam("key",k)
										.queryParam("q", l).get();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
	}

}
