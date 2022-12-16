package org.redbee.shared.error.model.exception

class BusinessException(
    private val description: String
) : RuntimeException(description) {

    fun getDescription(): String {
        return this.description
    }
}
