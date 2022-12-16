package org.redbee.shared.error.model.exception

abstract class GenericException(
    private val description: String
) : RuntimeException(description) {

    fun getDescription(): String {
        return this.description
    }
}
