package org.redbee.application.exception

class BusinessException(
    private val description: String
) {
    fun getDescription(): String {
        return this.description
    }
}
