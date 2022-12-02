package org.redbee.adapter.out.rest

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.redbee.adapter.out.rest.model.PokemonRestModel
import org.redbee.application.port.out.PokemonRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.GenericType

@Named("pokemonSource")
@ApplicationScoped
@RegisterRestClient
class PokemonRestAdapter() : PokemonRepository {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun get(name: String): Pokemon {
        log.info("Obteniendo pokemon con nombre:$name")
        val client: Client = ClientBuilder.newBuilder().build()
        val url = "https://pokeapi.co/api/v2/pokemon/$name"
        val pokemonResult: PokemonRestModel = client.target(url).request().get<PokemonRestModel>(object : GenericType<PokemonRestModel?>() {})
        val pokemon = pokemonResult.toDomain()
        log.info("Pokemon obtenido:$pokemon")

        return pokemon
    }
}
