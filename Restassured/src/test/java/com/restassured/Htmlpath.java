package com.restassured;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Htmlpath {

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://www.Lipsum.com/hindi";
		
		Response res=RestAssured.given().get();
		
		System.out.println(res.getBody().asPrettyString());
		
		XmlPath xp=res.htmlPath();
		String x=xp.getString("html.@lang");//node's attribute value 
		System.out.println(x);
		
		String x2=xp.getString("html.head.title");
		System.out.println(x2);
		
		
		String x3=xp.getString("**.find{it.@id='outer'}");
		System.out.println(x3);

	}

}
