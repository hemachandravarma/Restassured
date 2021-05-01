package com.restassured;
import java.util.Scanner;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;

public class Assertionsformat {

	public static void main(String[] args) {
		//take input from the keyboard
		Scanner sc=new Scanner(System.in);
		String k="e9c3b0195be341c795281747202311";
		System.out.println("Entel location");
		String loc=sc.nextLine();
		System.out.println("enter criteria like valid/ invalid");
		String cr=sc.nextLine();
		sc.close();
		
		//Submit request with query parametrs via http get method and validate
		//that the Json or xml response  body using one or more Hamcrest metchers 
		//Inline Assertions od restAssured to avoid hard coded validations.

		if(cr.equalsIgnoreCase("Valid")) //+ve case with valid data.	
		{
			RestAssured.given()
						.log()
						.all()
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
		else//-ve cases with valid data 
		{
			RestAssured.given()
						.log().all()
						.baseUri("https://api.weatherapi.com/v1/current.json")
						.queryParam("key", k)
						.queryParam("q", loc)
					.when()
					    .get()
					.then()
						.log().all()
						 .statusCode(400)
						 .header("Content-Type", 
								 Matchers.containsStringIgnoringCase("json"))	
						// .body("location.name", Matchers.containsStringIgnoringCase(loc));
						 .body("error.message", Matchers.containsString
								 ("No matching location found"));
			
		}	
	}

}
