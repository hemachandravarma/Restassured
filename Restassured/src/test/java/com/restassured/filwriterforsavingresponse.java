package com.restassured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;

public class filwriterforsavingresponse
{

	public static void main(String[] args) 
	{
		//Specify the base URI of restful service with year as path parameter 
		RestAssured.baseURI="https://ergast.com/api/f1/2019";
		
		//get the response 
		Response res=RestAssured.given().get();
		//create a XmlPath classes object on response body to parse the xml path expressions 
		XmlPath xp=new XmlPath(res.getBody().asString());
		//get count of all attributes of root node and display name with values 
		Node n1=xp.getNode("MRData");
		Map<String, String> l=n1.attributes();
		for(Map.Entry<String, String> me: l.entrySet()) 
		{
			System.out.println(me.getKey() + ":"+ me.getValue());
		}
		
		//To get give root node's attribute
		String v2=xp.getString("MRData.@limit");
		System.out.println(v2);
		
		String rootnodeattribute=res.getBody().xmlPath().getString(".@limit");
		System.out.println(rootnodeattribute);
		
		//to get attribute value of child node of root node 
		
		String v3=xp.getString("Mrdata.RaceTable.@season");
		System.out.println(v3);
		
		//to get attribute node of a descendant value of a root node
		String v4=xp.getString("Mrdata.RaceTable.Race.@round");
		System.out.println(v4);
		 //above and below statements are showing same format results 
		List<String> v41=xp.get("Mrdata.RaceTable.Race.@round");
		System.out.println(v41);
		
		//when we use the **(We can go any where in the response body), we need to use find o find all methods
		//using ** find node and get that node value 
		String v5=xp.getString("**.find{it.@season=='2019' && it.@round=='1'}");
		System.out.println(v5);
		
		//Using ** find the node and find the attribute value 
		String v6=xp.get("**.find{it.@season=='2019' && it.@round=='1'}.@url");
		System.out.println(v6);
		
		//Using ** find parent node and get child node 
		
		String v8=xp.get("**.find{it.@season=='2019' && it.@round=='1'}.RaceName");
		System.out.println(v8);
		
		//Using ** find parent node and find the child node's attributes
		String v7=xp.get("**.find{it.@season=='2019' && it.@round=='1'}MRdata.circuit."
				+ "@circuitId");
		System.out.println(v7);
		//using **(got to anywhere) find All with one condition on node name and size()
		int v9=xp.get("**.findAll{it.name()=='Race'}.size()");
		System.out.println(v9);
		
		//using ** findAll() with one condition on attribute and size()
		
		int v10=xp.get("**.findAll{it.@season=='2019'}.size()");
		System.out.println(v10);
		
		//using ** findAll() with more than one condition and size()
		
		int v11=xp.get("**.findAll{it.name()=='Race' && it.@season=='2019'"
				+ " && it.@round=='1'}.size()");
		System.out.println(v11);
		
		//using **, findAll() and child node with size
		
		int v12=xp.get("**.findAll{it.name()=='Race' && it.@season=='2019'}"
				+ ".RaceName.size()");
		System.out.println(v12);
		
		//using ** findAll() to get the values of the nodes 
		List<String> v13=xp.get("**.findAll{it.name()=='Race' && it.@season=='2019'}");
		System.out.println(v13);
		
		//using ** find all nodes and get required attribute values of those nodes 
		List<String> v14=xp.get("**.findAll{it.name=='Race' && it.season=='2019'}"
				+ ".@rounds");
		System.out.println(v14);
		
	}

}
