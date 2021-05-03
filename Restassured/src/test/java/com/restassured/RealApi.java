package com.restassured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RealApi {

	public static void main(String[] args) throws Exception 
	{
		//RestAssured.baseURI="";
		
		//create and send request vi http post method 
		JSONObject js=new JSONObject();
		js.put("action", "init_chat");
		js.put("device_print","ed79cf898a7951B5f8858d2d7f4f106f");
		js.put("chatbot_id", 4174);
		js.put("name", "SmatBot");
		js.put("Language_code", "default");
		
		//create and submit request with body paraameters
		FileOutputStream fo=new FileOutputStream("F:\\txt.txt");
		PrintStream ps= new PrintStream(fo);
		RestAssured.given().log().all()
							.baseUri("https://www.smatbot.com/Kya_backend/pagehub/chatbot_util")
							.header("content-Type","application/json")
							.body(js.toString())
							.filter(RequestLoggingFilter.logRequestTo(ps))
							.filter(ResponseLoggingFilter.logResponseTo(ps))
								
						.when()
							.post()
						.then()
							.log().body()
							.statusCode(200);
						
	}
}
