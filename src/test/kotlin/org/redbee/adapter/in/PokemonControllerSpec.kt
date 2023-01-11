package org.redbee.adapter.`in`

import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusMock
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.redbee.adapter.exception.NotFoundException
import org.redbee.application.usecase.GetPokemonByNameUseCase
import org.redbee.application.usecase.model.Pokemon

// Mock dependencies
val pokemonService: GetPokemonByNameUseCase = mockk()

@QuarkusTest
@TestInstance(PER_CLASS)
class PokemonControllerSpec {

    @BeforeAll
    fun setupMocks() {
        QuarkusMock.installMockForType(pokemonService, GetPokemonByNameUseCase::class.java)
    }

    @Test
    fun `PokemonControllerAdapter should respond to a GET petition with expected pokemon`() {
        val expectedPokemon = Pokemon(
            name = "Pikachu",
            types = listOf(
                "Eléctrico"
            ),
            abilities = listOf(
                "Impactrueno",
                "Onda Trueno"
            )
        )

        every { pokemonService.execute(any()) } returns expectedPokemon

        given()
            .`when`().get("/api/v1/pokemons/pikachu")
            .then()
            .statusCode(200)
            .body(`is`("{\"name\":\"Pikachu\",\"abilities\":[\"Impactrueno\",\"Onda Trueno\"],\"types\":[\"Eléctrico\"]}"))
    }

    @Test
    fun `PokemonControllerAdapter should respond to a GET petition when given pokemon was not found with a error code 404`() {

        val expectedMessage = "Pokemon not found"

        every { pokemonService.execute(any()) } throws NotFoundException(expectedMessage)

        given()
            .`when`().get("/api/v1/pokemons/pikachu")
            .then()
            .statusCode(404)
            .body(`is`("{\"description\":\"$expectedMessage\"}"))
    }
}
