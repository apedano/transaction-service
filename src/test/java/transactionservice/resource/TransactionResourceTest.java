package transactionservice.resource;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import transactionservice.config.WiremockAccountService;

import static io.restassured.RestAssured.given;

@QuarkusTest
@QuarkusTestResource(WiremockAccountService.class) //Adds the life cycle manager for WireMock to the test
public class TransactionResourceTest {

    @Test
    void testTransaction() {
        given()
                .body("142.12")
                .contentType(ContentType.JSON)
                .when().post("/api/transactions/{accountNumber}", 121212)
                .then()
                .statusCode(200);
    }
}
