package org.redbee.adapter.`in`

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class PokemonControllerSpec {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/api/v1/pokemons/pikachu")
            .then()
            .statusCode(200)
            .body(`is`("{\"name\":\"sarasa\",\"abilities\":[\"sarasa2\"],\"types\":[\"sarasa3\"]}"))
    }
}
