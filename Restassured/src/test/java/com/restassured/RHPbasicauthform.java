package com.restassured;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;

public class RHPbasicauthform {

	public static void main(String[] args)
	{
		// Register aa restful service resource under testing
		RestAssured.baseURI="https://guru99.com/v1/index.php";
		FormAuthConfig fc=new FormAuthConfig("index.php","uid","password");
				
		//Create and submit request via basic authentication 
		Response res=RestAssured.given().auth().form("mngr318465", "qUsajAv", fc).post();
				
		//Display response came from the rest assured service.
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	} 
}