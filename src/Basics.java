import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//validate if addplace is working as expected
		 //here given is static so manually need to declare the library
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json;charset=UTF-8")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"RR Studio\",\r\n"
				+ "  \"phone_n	umber\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json")
		        .then().log().all().assertThat().statusCode(200)
		        .body("scope",equalTo("APP"))  
	         	.header("Server", "Apache/2.4.52 (Ubuntu)");                                     
         //equalTo is static
		//validation needed for server because response should come from the correct server. to protect from hack 
		
		//Add place->update place with New Address-> get place with new address is present in response
		
		//update place with new address
		// to do that 1st retrive the id and then store into a variable and use it.
		
		
	}

}
