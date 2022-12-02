package org.redbee.application.usecase

import org.redbee.application.port.`in`.CreateDigimonCommand
import org.redbee.application.port.out.CreateDigimonRepository
import org.redbee.application.usecase.model.Digimon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateDigimonUseCase(
    private val createDigimonRepository: CreateDigimonRepository
) : CreateDigimonCommand {
    private val log = LoggerFactory.getLogger(this::class.java)

    private val EMPTY_LEVELS = ""

    override fun execute(command: CreateDigimonCommand.Command): Unit {
        log.info("Ejecutando caso de uso de creacion de digimon :${command.toString()}")
        val digimonToCreate = buildDigimon(command)
        createDigimonRepository.execute(digimonToCreate)
        log.info("Digimon creado con exito")
    }

    private fun buildDigimon(command : CreateDigimonCommand.Command) : Digimon {
        return Digimon(command.getName(), EMPTY_LEVELS)
    }
}
