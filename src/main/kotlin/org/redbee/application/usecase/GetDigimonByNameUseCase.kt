package org.redbee.application.usecase

import org.redbee.application.port.`in`.GetDigimonByNameQuery
import org.redbee.application.port.out.GetDigimonByNameRepository
import org.redbee.application.port.out.PokemonRepository
import org.redbee.application.usecase.model.Digimon
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetDigimonByNameUseCase(
    private val getDigimonByNameRepository: GetDigimonByNameRepository
) : GetDigimonByNameQuery {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Digimon {
        log.info("Ejecutando caso de uso de obtener digimon con nombre:$name")
        val digimon = getDigimonByNameRepository.execute(name)
        log.info("Digimon obtenido:${digimon.toString()}")

        return digimon
    }
}