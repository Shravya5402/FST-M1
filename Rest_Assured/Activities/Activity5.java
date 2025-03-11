@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    // Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {        
        return builder.given("POSTRequest")
            .uponReceiving("A request to add data")
                .method("POST")
                .path("/api/path")
                .body(reqResBody)
            .willRespondWith()
                .status(200)
                .body(reqResBody)
            .toPact();
    }

    // Consumer test with mock provider
    @Test
    @PactTestFor(providerName = "TestProvider", port = "9000")
    public void postRequestTest() {
        // Create a request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Taro");
        reqBody.put("lastName", "Sakamoto");
        reqBody.put("email", "sakamotodays@example.com");

        // Send request, get response, assert response
        given()
            .baseUri("http://localhost:9000/api/path")
            .body(reqBody)
            .log().all()
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("lastName", equalTo("Sakamoto")).log().all();
    }
}