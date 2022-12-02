package org.redbee.adapter.`in`.controller

import org.redbee.adapter.`in`.controller.model.PokemonResponse
import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.redbee.config.ErrorMapper
import org.slf4j.LoggerFactory
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("/api/v1/pokemons")
class PokemonControllerAdapter(
    private val getPokemonByNameQuery: GetPokemonByNameQuery,
    private val errorMapper: ErrorMapper
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

/*    @ServerExceptionMapper
    fun mapException(e : Throwable) : RestResponse<Error> = this.errorMapper.mapException(e)*/
}
