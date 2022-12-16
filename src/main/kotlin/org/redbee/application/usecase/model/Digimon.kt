package org.redbee.application.usecase.model

class Digimon(
    private val name: String,
    private val level: String
) {
    fun getName(): String {
        return this.name
    }

    fun getLevel(): String {
        return this.level
    }

    override fun toString(): String {
        return "Digimon(name='$name', level='$level')"
    }
}
