package org.redbee.adapter.`in`.controller

import org.redbee.adapter.`in`.controller.model.DigimonRequest
import org.redbee.application.port.`in`.CreateDigimonCommand
import org.slf4j.LoggerFactory
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/api/v1/digimons")
class DigimonControllerAdapter(
    private val createDigimonCommand: CreateDigimonCommand
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @POST
    fun create(body : DigimonRequest) : Response {
        log.info("Se llama a api para creacion digimon con body :${body.toString()}")
        createDigimonCommand.execute(buildCommand(body))
        log.info("Digimon creado exitosamente")
        return Response.status(201).build()
    }

    private fun buildCommand(body : DigimonRequest) : CreateDigimonCommand.Command{
        return CreateDigimonCommand.Command(body.getName())
    }

}