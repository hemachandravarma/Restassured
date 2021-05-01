package com.restassured;

import java.util.Scanner;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class Assertionswitherrormessages {

	public static void main(String[] args) 
	{
		// Take input from the keyboard
		Scanner sc=new Scanner(System.in);
		String k="e9c3b0195be341c795281747202311";
		System.out.println("Enter locationlike city name");
		String loc=sc.nextLine();
		System.out.println("enter criteria like valid/invalid");
		String cr=sc.nextLine();
		sc.close();
		
		//Submit request with query parameters via http get method and validate the
		//json or htl response via one or more hamcrest to avoid the hard code assertions.
		if(cr.equalsIgnoreCase("valid")) 
		{
			RestAssured.given()
					  // .log()
					  // .all()
					   .baseUri("https://api.weatherapi.com/v1/current.json")
					   .queryParam("key", k)
					   .queryParam("q", loc)
					.when()
						.get()
					.then()
					  .log()
					  .all()
					  .statusCode(200)
					  .header("Content-Type", Matchers.containsStringIgnoringCase("json"))
					  .body("location.name", Matchers.containsStringIgnoringCase(loc));
		}
		else
		{
			RestAssured.given()
					  // .log().all()
					   .baseUri("https://api.weatherapi.com/v1/current.json")
					   .queryParam("key", k)
					   .queryParam("q",loc)
					.when()  
						.get()
					.then()
						//.log().all()
						.statusCode(400)
						.header("Content-Type", Matchers.containsStringIgnoringCase("json"))
						.body("error.message", Matchers.containsString("No matching location found"));
		}

	}

}
