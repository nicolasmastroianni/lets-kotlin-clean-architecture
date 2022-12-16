package org.redbee.application.exception

class BusinessException(
    private val description: String
) : Throwable() {
    fun getDescription(): String {
        return this.description
    }
}
