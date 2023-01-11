package org.redbee.application.usecase

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.mockk.every
import io.mockk.mockk
import org.redbee.adapter.exception.NotFoundException
import org.redbee.application.port.out.CreatePokemonRepository
import org.redbee.application.port.out.GetPokemonByNameRepository
import org.redbee.application.usecase.model.Pokemon
import org.redbee.shared.error.model.ErrorDescription

class GetPokemonByNameUseCaseSpec: BehaviorSpec() {

    init {
        Given("GetPokemonByName") {
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

            val foundPokemon = "Pikachu"
            val notFoundPokemon = "Agumon"

            val pokemonSourceRepository = mockk<GetPokemonByNameRepository> {
                every { execute(foundPokemon) } returns expectedPokemon
                every { execute(notFoundPokemon) } throws NotFoundException(ErrorDescription.NOT_FOUND.value)
            }

            val getPokemonByNameRepository = mockk<GetPokemonByNameRepository> {
                every { execute(foundPokemon) } returns expectedPokemon
                every { execute(notFoundPokemon) } throws NotFoundException(ErrorDescription.NOT_FOUND.value)
            }

            val pokemonResourceRepository = mockk<GetPokemonByNameRepository> {
                every { execute(foundPokemon) } returns expectedPokemon
                every { execute(notFoundPokemon) } throws NotFoundException(ErrorDescription.NOT_FOUND.value)
            }

            val createPokemonRepository = mockk<CreatePokemonRepository> {
                every { execute(expectedPokemon) } returns expectedPokemon
            }



            val useCase = GetPokemonByNameUseCase(
                pokemonSourceRepository,
                pokemonResourceRepository,
                createPokemonRepository,
                getPokemonByNameRepository
            )

            When("Invoke getPokemonByNameRepository with foundPokemon name") {
                val result = useCase.execute(foundPokemon)
                Then("result from useCase should be equals to expected pokemon") {
                    result shouldBe expectedPokemon
                }
            }

            When("Invoke getPokemonByNameRepository with notFoundPokemon name") {
                val exception = shouldThrow<NotFoundException> { useCase.execute(notFoundPokemon) }
                Then("exception message should be equal to expected") {
                    exception.message should startWith("Recurso no encontrado")
                }
            }
        }
    }
}