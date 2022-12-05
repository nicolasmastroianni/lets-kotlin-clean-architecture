package org.redbee.adapter.out.redis

import io.quarkus.redis.datasource.RedisDataSource
import io.quarkus.redis.datasource.value.ValueCommands
import org.redbee.application.port.out.GetPokemonByNameRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@ApplicationScoped
@Named("getPokemonCache")
class GetPokemonByNameRedisAdapter(
    ds: RedisDataSource
): GetPokemonByNameRepository{

    private val log = LoggerFactory.getLogger(this::class.java)
    private val commands: ValueCommands<String, Pokemon> = ds.value(String::class.java, Pokemon::class.java)
    override fun execute(name: String): Pokemon? {
        log.info("Obteniendo pokemon por nombre: ${name}")
        val pokemon = commands.get(name)
        log.info("Pokemon obtenido desde Redis: ${pokemon}")
        return pokemon
    }
}