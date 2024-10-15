package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import java.util.UUID

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello")
          .then()
             .statusCode(200)
             .body(`is`("Hello from Quarkus REST"))
    }

    @Test
    fun testGreetingEndpoint() {

        val uuid = UUID.randomUUID().toString()

        given()
            .pathParam("name", uuid)
            .`when`().get("/hello/greeting/{name}")
            .then()
            .statusCode(200)
            .body(`is`( "hello " + uuid))

    }

}