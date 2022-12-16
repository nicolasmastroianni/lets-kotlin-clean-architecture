package org.redbee.adapter.out.redis

import io.quarkus.redis.datasource.RedisDataSource
import io.quarkus.redis.datasource.value.ValueCommands
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.redbee.application.port.out.CreatePokemonRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreatePokemonRedisAdapter(
    ds: RedisDataSource,
    @ConfigProperty(name = "quarkus.redis.duration")private val duration: Long
) : CreatePokemonRepository {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val commands: ValueCommands<String, Pokemon> = ds.value(String::class.java, Pokemon::class.java)
    override fun execute(pokemon: Pokemon): Pokemon {
        log.info("Creando pokemon: $pokemon")
        commands.setex(pokemon.name, duration, pokemon)
        log.info("Pokemon creado exitosamente")
        return pokemon
    }
}
