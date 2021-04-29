package com.restassured;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Restassured4 
{
	public static void main(String args[]) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the user id");
		String x=sc.nextLine();
		sc.close();
		//Register URI of resource under testing 
		RestAssured.baseURI="https://reqres.in/api/login"+x;
		//create and submit request via delete method 
		Response res=RestAssured.given().delete();
		//display response came from the restful service resource 
		System.out.println(res.getStatusLine() + "Record deleted successfully");
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());	
		
	}
	   
}
