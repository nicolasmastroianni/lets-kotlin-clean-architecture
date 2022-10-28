package org.redbee.application.usecase

import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.redbee.application.port.out.PokemonRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetPokemonByNameUseCase(
    private val pokemonRepository : PokemonRepository
) : GetPokemonByNameQuery {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name : String): Pokemon {
        log.info("Ejecutando caso de uso de obtener pokemon con nombre:$name")
        val pokemon = pokemonRepository.get(name)
        log.info("Pokemon obtenido:${pokemon.toString()}")

        return pokemon
    }
}