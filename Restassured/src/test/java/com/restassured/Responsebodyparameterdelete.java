package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Responsebodyparameterdelete {

	public static void main(String[] args) 
	{
		//take input from the keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a value like id or name");
		String x=sc.nextLine();
		sc.close();
		//register a restful service resource under test 
		RestAssured.baseURI="https://reqres.in/api/users"  +x;
		
		//Create and submit the response via Http delete method to delete the records
		Response res=RestAssured.given().delete();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		
	}

}
