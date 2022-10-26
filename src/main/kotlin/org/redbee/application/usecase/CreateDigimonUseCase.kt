package org.redbee.application.usecase

import org.redbee.application.port.`in`.CreateDigimonCommand
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateDigimonUseCase() : CreateDigimonCommand {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(command: CreateDigimonCommand.Command): Unit {
        log.info("Ejecutando caso de uso de creacion de digimon :${command.toString()}")
        //vamo a darle al repository
        log.info("Digimon creado con exito")
    }
}