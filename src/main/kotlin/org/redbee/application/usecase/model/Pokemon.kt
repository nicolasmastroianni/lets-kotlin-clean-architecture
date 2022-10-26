package org.redbee.application.usecase.model

class Pokemon(
    private val name: String,
    private val abilities: List<String>,
    private val types: List<String>
) {

    fun getName() : String{
        return this.name
    }

    fun getAbilities() : List<String> {
        return this.abilities
    }

    fun getTypes() : List<String> {
        return this.types
    }

    override fun toString(): String {
        return "Pokemon(name='$name', abilities=$abilities, types=$types)"
    }
}
