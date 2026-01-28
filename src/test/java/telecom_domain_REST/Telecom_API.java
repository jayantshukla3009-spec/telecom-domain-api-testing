package telecom_domain_REST;

import org.testng.annotations.BeforeClass;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telecom_resource.Contact_POJO;
import telecom_resource.UserResponse_POJO;
import telecom_resource.addUser_POJO;

public class Telecom_API { 
	String userToken ;
	RequestSpecification reqSpec;
	String dynamicEmail;
	String Id;
	
@BeforeClass
public void setUp() {
	RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
	reqSpec = RestAssured.given().header("Content-Type","application/json");
}
	
	//POST
@Test(priority = 1)
public void addNewUser() {
	dynamicEmail = "jayantshukla"+(System.nanoTime()%10000)+"@fake.com";
	addUser_POJO userDetails = new addUser_POJO();
	userDetails.setFirstName("Jayant");
	userDetails.setLastName("Shukla");
	userDetails.setEmail(dynamicEmail);
	userDetails.setPassword("myPassword");
	Response response = RestAssured.given().headers("Content-Type", "application/json").body(userDetails)
	.when().post("/users");
	// validation
	response.then().statusCode(201);
	UserResponse_POJO token =  response.as(UserResponse_POJO.class);//deserialize
	userToken = token.getToken();
	
	
}
//GET
@Test(priority = 2 , dependsOnMethods = "addNewUser")
public void getUserProfile() {
	Response response =  RestAssured.given().header("Authorization", "Bearer "+userToken).when()
	.get("/users/me");
	// validation
	response.then().statusCode(200); // status code match 200 
	response.then().statusLine("HTTP/1.1 200 OK");
	response.then().log().body();
}
//PATCH 
@Test(priority = 3 , dependsOnMethods = "getUserProfile")
public void updateUser() {
	addUser_POJO update = new addUser_POJO();
	update.setFirstName("Harsh");
	update.setLastName("Vardan");
	update.setEmail(dynamicEmail);
	update.setPassword("myNewPassword");
	Response response = RestAssured.given().spec(reqSpec).header("Authorization", "Bearer "+userToken).body(update)
	.when().patch("/users/me");
	//Validation
	response.then().log().body();
	response.then().statusCode(200);
	response.then().statusLine("HTTP/1.1 200 OK");
	
	
}

//POST -> login
@Test(priority = 4 , dependsOnMethods = "updateUser")
public void loginUser() {
	HashMap<String, String> credentials = new HashMap<>();
	credentials.put("email", dynamicEmail);
	credentials.put("password", "myNewPassword");
	Response response = RestAssured.given().spec(reqSpec).body(credentials).when()
			.post("/users/login");
	response.then().statusCode(200);
	response.then().statusLine("HTTP/1.1 200 OK");
	userToken = response.jsonPath().get("token");//token using jsonPath();
}

@Test(priority = 5 ,dependsOnMethods = "loginUser")
public void addContact() {
	Contact_POJO add = new Contact_POJO();
	add.setFirstName("Riya");
	add.setLastName("Singh");
	add.setBirthdate("1998-09-01");
	add.setEmail("jdoe@fake.com");
	add.setPhone("8005555555");
	add.setStreet1("1 Main St.");
	add.setStreet2("Apartment A");
	add.setCity("Anytown");
	add.setStateProvince("KS");
	add.setPostalCode("12345");
	add.setCountry("USA");
	
	Response response = RestAssured.given().spec(reqSpec).header("Authorization","Bearer "+userToken).body(add)
			.when().post("/contacts");
	response.then().statusCode(201);
	response.then().body("firstName", equalTo("Riya"));
	
}
@Test(priority = 6,dependsOnMethods = "addContact")
public void getContact() {
	Response response = RestAssured.given().header("Authorization","Bearer "+userToken).when().get("/contacts");
	response.then().statusCode(200);
	Id = response.jsonPath().getString("[0]._id");
}
@Test(priority = 7,dependsOnMethods = "getContact")
public void getContactId() {
	Response response = RestAssured.given().header("Authorization","Bearer "+userToken).when().get("/contacts/"+Id);
	response.then().statusCode(200);
	response.then().log().body();
	response.then().body("_id", equalTo(Id));
}
@Test(priority = 8,dependsOnMethods = "getContactId")
public void updateFullContact() {
	Contact_POJO update = new Contact_POJO();
	update.setFirstName("Meera");
	update.setLastName("Singh");
	update.setBirthdate("1992-10-11");
	update.setEmail("msingh@fake.com");
	update.setPhone("7896541230");
	update.setStreet1("2 Main St.");
	update.setStreet2("Apartment B");
	update.setCity("Fromtown");
	update.setStateProvince("NA");
	update.setPostalCode("54789");
	update.setCountry("Canada");
	Response response = RestAssured.given().spec(reqSpec).headers("Authorization","Bearer "+userToken).body(update)
			.when().put("/contacts/"+Id);
	response.then().statusCode(200);
	response.then().body("email", equalToIgnoringCase("msingh@fake.com"));
}

@Test(priority = 9,dependsOnMethods = "updateFullContact")
public void updatePartialContact() {
	HashMap<String , String > update = new HashMap<>();
	update.put("firstName", "Anna");
	Response response = RestAssured.given().spec(reqSpec).headers("Authorization","Bearer "+userToken).body(update)
			.when().patch("/contacts/"+Id);
	response.then().statusCode(200);
	response.then().log().body();
	response.then().body("firstName", equalTo("Anna"));
			}

@Test(priority = 10,dependsOnMethods = "updatePartialContact")
public void logOut() {
	Response response = RestAssured.given().headers("Authorization","Bearer "+userToken).when().post("/users/logout");
	response.then().statusCode(200);
	response.then().statusLine("HTTP/1.1 200 OK");
}
@Test(priority = 11)
public void negativeTest() {
	HashMap<String, String> credentials = new HashMap<>();
	credentials.put("email", dynamicEmail);
	credentials.put("password", "wrongPassword");
	Response response = RestAssured.given().spec(reqSpec).body(credentials).when().post("/users/login");
	response.then().statusCode(401);
	
}
}










