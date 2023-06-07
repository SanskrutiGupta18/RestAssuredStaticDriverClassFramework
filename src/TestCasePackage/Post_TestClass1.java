package TestCasePackage;
import java.io.IOException;
import org.testng.Assert;
import Common_Functions_Package.Utility_Common_Function;
import Common_Functions_Package.API_Common_Functions;
import io.restassured.path.json.JsonPath;
import RepositoryPackage.Post_Method_Repository;
public class Post_TestClass1 {

	public static void execute() throws IOException {
		for(int i=0; i<5; i++) 
		{
			int status_Code = API_Common_Functions.statusCode(Post_Method_Repository.base_URI(),Post_Method_Repository.post_resource(),Post_Method_Repository.requestBody1());
			if(status_Code==201)
			{
				String responsebody= API_Common_Functions.responsebody(Post_Method_Repository.base_URI(), Post_Method_Repository.post_resource(),Post_Method_Repository.requestBody1());
				Post_TestClass1.validator(responsebody,status_Code);
                Utility_Common_Function.evidencefilecreator("EvidenceTestCase1", Post_Method_Repository.requestBody1(), responsebody);
				break;
			}
			else
			{
				System.out.println("Status code found is not as expected therefore retrying the API");
			}
		}
		}
	
		public static void validator(String response_Body,int status_Code) throws IOException {
			//parse	the response body
			JsonPath jspr = new JsonPath(Post_Method_Repository.requestBody1());
			String req_name = jspr.getString("name");
			String req_job = jspr.getString("job");
			JsonPath jsp=new JsonPath(response_Body);
			String res_name=jsp.getString("name");
			String res_job=jsp.getString("job");
			String res_id=jsp.getString("id");
			String res_createdAt=jsp.getString("createdAt");
			
			System.out.println(res_name);
			System.out.println(res_job);
			System.out.println(res_id);
			System.out.println(res_createdAt);
			
		//validate response body 
	    Assert.assertEquals(status_Code,201);
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
		Assert.assertNotNull(res_id);
		Assert.assertNotNull(res_createdAt);
		System.out.println("Validated successfully");
	}
}
