package org.redbee.application.usecase

import org.redbee.application.port.`in`.GetPokemonByNameQuery
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetPokemonByNameUseCase : GetPokemonByNameQuery {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Pokemon {
        log.info("Ejecutando caso de uso de obtener pokemon con nombre:$name")
        val pokemon = Pokemon("sarasa", listOf("sarasa2"), listOf("sarasa3"))
        log.info("Pokemon obtenido: $pokemon")

        return pokemon
    }
}
