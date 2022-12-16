package org.redbee.config

import ErrorResponse
import org.redbee.adapter.exception.NotAvailableException
import org.redbee.adapter.exception.NotFoundException
import org.redbee.adapter.exception.UnprocessableException
import org.redbee.application.exception.BusinessException
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response

@ApplicationScoped
class ErrorHandler {
    companion object {
        fun mapException(e: Throwable): Response =
            when (e) {
                is NotFoundException -> buildError(404, e.getDescription())
                is BusinessException -> buildError(409, e.getDescription())
                is UnprocessableException -> buildError(422, e.getDescription())
                is NotAvailableException -> buildError(503, e.getDescription())
                else -> buildError(500, ErrorDescription.UNHANDLED.value)
            }

        private fun buildError(status: Int, description: String): Response {
            return Response.status(status).entity(ErrorResponse(description)).build()
        }
    }
}
