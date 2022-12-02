package org.redbee.config

abstract class GenericException(
    private val description: String
) : Throwable() {

    fun getDescription(): String {
        return this.description
    }
}
