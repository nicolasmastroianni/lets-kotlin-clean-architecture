package org.redbee.adapter.`in`.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import org.redbee.adapter.`in`.controller.model.PokemonResponse
import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.slf4j.LoggerFactory

@Path("/api/v1/pokemons")
class PokemonControllerAdapter(
    private val getPokemonByNameQuery: GetPokemonByNameQuery
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @GET
    @Path("/{name}")
    fun get(@PathParam("name") name: String): PokemonResponse {
        log.info("Obteniendo pokemon por nombre: $name")
        val pokemon = getPokemonByNameQuery.execute(name)
        val pokemonResponse = PokemonResponse.fromDomain(pokemon)
        log.info("Pokemon obtenido: $pokemon")

        return pokemonResponse
    }
}
