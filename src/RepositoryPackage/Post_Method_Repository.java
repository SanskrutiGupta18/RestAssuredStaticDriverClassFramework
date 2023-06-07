package RepositoryPackage;
import java.io.IOException;
import java.util.ArrayList;
import Common_Functions_Package.Utility_Common_Function;

public class Post_Method_Repository {
	
	public static String base_URI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String post_resource() {
		String resource ="/api/users";
		return resource;
	}
	public static String requestBody1() throws IOException {
		ArrayList<String> data=Utility_Common_Function.readdataexcel("Post_TestClass","Post_TestClass1");
		String req_name=data.get(1);
		String req_job=data.get(2);
	
		String requestBody = "{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
	}
}