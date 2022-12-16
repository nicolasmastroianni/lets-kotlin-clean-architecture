package org.redbee.application.usecase

import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.redbee.application.port.out.CreatePokemonRepository
import org.redbee.application.port.out.GetPokemonByNameRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@ApplicationScoped
class GetPokemonByNameUseCase(
    @Named("pokemonSource") private val pokemonSourceRepository: GetPokemonByNameRepository,
    @Named("pokemonResource") private val pokemonResourceRepository: GetPokemonByNameRepository,
    private val createPokemonRepository: CreatePokemonRepository,
    @Named("getPokemonCache") private val getPokemonByNameRepository: GetPokemonByNameRepository
) : GetPokemonByNameQuery {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Pokemon {
        log.info("Ejecutando caso de uso de obtener pokemon con nombre:$name")
        val pokemon = getPokemonByNameRepository.execute(name) ?: createPokemonRepository.execute(pokemonSourceRepository.execute(name)!!)
        val pokemonComplement = pokemonResourceRepository.execute(name)!!
        val pokemonResponse = Pokemon(
            pokemon.name,
            pokemon.abilities,
            pokemonComplement.types
        )
        log.info("Pokemon obtenido:$pokemonResponse")

        return pokemonResponse
    }
}
