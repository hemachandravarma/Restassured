package com.restassured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PeetStoreExample 
{
	public static void main(String args[]) 
	{
		/*		given()
				    .baseUri("https://reqres.in") 
				    .basePath("api/users/10")
				    .headers("Content-Type","Application/json")
				.when()    
				  // .get()
				   
				.then()
				  .log().all();
				  
				  */
	/*	File f=new File("src\\test\\testfile.json");
	given()
	    .baseUri("https://jsonplaceholder.typicode.com/posts") 
	    .headers("Content-Type","Application/xml")
	    .body(f)
	.when()    
	    .post() 
	.then()
	    .log().all();
	    
	    f.close();
		
		*/
		
		
	/*	JSONObject js=new JSONObject();
		
		js.put("name", "hemachandravarma ");
		js.put("id", "10689400");
	    js.put("Designation", "Quality Engineer");
		js.put("email", "varma.hemachandra01@gmail.com");
				
		given()
		    .baseUri("https://reqres.in/api/users") 
		    .headers("Content-Type","Application/xml")
		    .body(js.toString())
		.when()  
		
		   .patch()
		   
		.then()
		
		    .log().all();*/
		
		
	/*	given()
	    .baseUri("https://the-internet.herokupp.com/basic_auth") 
	    .auth().preemptive().basic("admin", "admin")
	.when()  
	   .get()
	.then()
	    .log().all();*/
		
	/*	given()
	    .baseUri("https://petstore.swagger.io/v2/pet/3") 
	    //.auth().preemptive().basic("admin", "admin")
	.when()  
	   .get()
	.then()
	    .log().all();
		
		*/
		
	String s1="{\r\n" +
	            " \"userName\": \"batch256\",\r\n" +
		    	"\"password\" : \"India@11\"\r\n" +
				"}";
			/*given()
				.baseUri("https://github.com/hemachandravarma")
				.auth().oauth2("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")
			.when()
			    .get("Restassured.git")
			.then()
			    .log().all();
			    }*/
		/*given()
		   .baseUri("http://the-internet.herokupp.com/basi_auth")
		   .auth().basic("admin","admin")
		   
		.when()
		    .get()
		.then()
		   .log().all();*/
		
		
		
	
	//JSONObject js=new JSONObject();
		//js.put("username", "batch256");
	//	js.put("password", "India@");
		
		Response res=given()
		  .baseUri("https://bookstore.toolsqa.com/Account/v1/user")
		  .header("Content-Type","application/Json")
		  .body(s1)
		  
		.when()
		  .post();
		
		String x=res.getBody().jsonPath().getString("token");
		System.out.println(x);
		
		String s2= "{\r\n "
				+ " \"isbn\": \"978144925856\", \r\n" 
				+" \"userId\": \"bf58438c-5df7-46d1-a540-ea346b31ec58\"\r\n}";
		given()
		   .baseUri("https://bookstore.toolsqa.com/BookStore/v1/Book")
		   .header("Autarization","Bearer "+x)
		   .header("Content-Type", "Application/json")
		   .body(2)
		.when()
		  .delete()
		 .then()
		   .log().all();
		  
	}
}