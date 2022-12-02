package org.redbee.application.usecase

import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.redbee.application.port.out.PokemonRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@ApplicationScoped

class GetPokemonByNameUseCase(
    @Named("pokemonSource") private val pokemonSourceRepository : PokemonRepository,
    @Named("pokemonResource") private val pokemonResourceRepository : PokemonRepository
) : GetPokemonByNameQuery {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name : String): Pokemon {
        log.info("Ejecutando caso de uso de obtener pokemon con nombre:$name")
        val pokemon = pokemonSourceRepository.get(name)
        val pokemonComplement = pokemonResourceRepository.get(name)
        val pokemonResponse = Pokemon(pokemon.name,
            pokemon.abilities,
            pokemonComplement.types)
        log.info("Pokemon obtenido:${pokemonResponse.toString()}")

        return pokemonResponse
    }
}
