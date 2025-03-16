package liveProject;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.Matchers.equalTo;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	//set the header
	Map<String, String> headers = new HashMap<>();
	
	//create the contact(pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		//set the headers
		headers.put("Content-Type", "application/json");
		
		//the request & response body
		DslPart reqResBody = new PactDslJsonBody()
				.numberType("id", 123)
				.stringType("firstName", "Rupa")
				.stringType("lastName", "Naik")
				.stringType("email", "rupanaik@ibm.com");
		
		//create the pact
		return builder.given("POST Request")
			.uponReceiving("A Request to create a user")
				.method("POST")
				.path("/api/users")
				.headers(headers)
				.body(reqResBody)
			.willRespondWith()
				.status(201)
				.body(reqResBody)
			.toPact();		
	}
	
	@Test
	@PactTestFor(providerName =  "UserProvider", port = "8282")
	public void postRequestTest() {
		//create a request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "Rupa");
		reqBody.put("lastName", "Naik");
		reqBody.put("email", "rupanaik@ibm.com");
		
		//send request, get response, add assertions
		given().baseUri("http://localhost:8282/api")
		.headers(headers).body(reqBody).log().all()
		.when().post()
		.then().statusCode(201).body("email", equalTo("rupanaik@ibm.com")).log().all();
		
	}

}
