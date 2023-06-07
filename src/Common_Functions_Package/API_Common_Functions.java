package Common_Functions_Package;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class API_Common_Functions {
			public static int statusCode(String baseURI,String resource,String requestBody) {
			RestAssured.baseURI=baseURI;
		
			int statusCode=given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().statusCode();
			
			return statusCode;
	}
			public static String responsebody(String baseURI,String resource,String requestBody) {
			
			RestAssured.baseURI=baseURI;
		
			String responseBody =given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().response().asString();
			
			return responseBody;
	}
}
