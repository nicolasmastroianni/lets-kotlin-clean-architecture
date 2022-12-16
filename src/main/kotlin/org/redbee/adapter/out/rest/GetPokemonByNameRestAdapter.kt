package org.redbee.adapter.out.rest

import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.redbee.adapter.exception.NotAvailableException
import org.redbee.adapter.out.rest.model.PokemonRestModel
import org.redbee.application.port.out.GetPokemonByNameRepository
import org.redbee.application.usecase.model.Pokemon
import org.redbee.config.ErrorDescription
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named
import javax.ws.rs.ClientErrorException
import javax.ws.rs.NotFoundException
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.GenericType

@Named("pokemonSource")
@ApplicationScoped
@RegisterRestClient
class GetPokemonByNameRestAdapter(
    @ConfigProperty(name = "quarkus.rest-client.pokemon.url")private val basePath: String
) : GetPokemonByNameRepository {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Pokemon {
        try {
            log.info("Obteniendo pokemon con nombre:$name")
            val client: Client = ClientBuilder.newBuilder().build()
            val pokemonResult: PokemonRestModel = client
                .target("$basePath/$name")
                .request()
                .get<PokemonRestModel>(object : GenericType<PokemonRestModel?>() {})
            val pokemon = pokemonResult.toDomain()
            log.info("Pokemon obtenido:$pokemon")

            return pokemon
        } catch (ex: NotFoundException) {
            throw org.redbee.adapter.exception.NotFoundException(ErrorDescription.NOT_FOUND.value)
        } catch (ex: ClientErrorException) {
            throw NotAvailableException(ErrorDescription.UNHANDLED.value)
        }
    }
}
