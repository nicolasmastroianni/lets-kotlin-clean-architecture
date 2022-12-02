package org.redbee.config

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ErrorMapper {

  /*  //Mapeo en libreria
    fun mapException(e: Throwable): RestResponse<ErrorDto> =
        when(e) {
            is ResteasyReactiveViolationException -> {
                this.responseBuilderFor(e).build(
                    status = 400,
                    body = BadRequestErrorDto(code = "bad_request", errors = e.constraintViolations.map { RequestError(it.message) }.distinct())
                )
            }

            is BadRequestException -> this.responseBuilderFor(e).build(
                status = 400,
                body = BadRequestErrorDto(code = "bad_request", errors = e.errors.distinct())
            )
            is NotFoundException -> this.responseBuilderFor(e).build(
                status = 404,
                body = DefaultErrorDto(code = "not_found", message = e.message?:"Resource not found")
            )
            is BusinessException -> this.responseBuilderFor(e).build(
                status = 422,
                body = DefaultErrorDto(code = "business_error",  message = e.message?:"Something went wrong")
            )
            is TimeoutException -> this.responseBuilderFor(e).build(
                status = 500,
                body = DefaultErrorDto(code = "server_timeout", message = "The server timed out when communicating with another server")
            )
            is CommunicationException -> this.responseBuilderFor(e).build(
                status = 500,
                body = DefaultErrorDto(code = "server_error", message = "The server failed to establish connection with another server")
            )
            else -> this.responseBuilderFor(e).build(
                status = 500,
                body = DefaultErrorDto(code = "server_error", message = "Something went wrong")
            )
        }

    private fun responseBuilderFor(_e: Throwable): ResponseBuilder<ErrorDto, RestResponse<ErrorDto>> =
        ResponseBuilder { status, body ->
            RestResponse.status(
                RestResponse.Status.fromStatusCode(status),
                body
            )
        }
*/
}
