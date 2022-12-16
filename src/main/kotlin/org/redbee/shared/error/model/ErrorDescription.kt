package org.redbee.shared.error.model

enum class ErrorDescription(val value: String) {
    UNHANDLED("Ha ocurrido un error inesperado."),
    NOT_FOUND("Recurso no encontrado."),
    ERROR_CONNECTION("Ha ocurrido un error en la conexion."),
    TIMEOUT("Ha ocurrido un timeout en la conexion."),
    DUPLICATED("El recurso ya existe.")
}
