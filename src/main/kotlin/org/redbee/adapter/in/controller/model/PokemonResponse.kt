package org.redbee.adapter.`in`.controller.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.redbee.application.usecase.model.Pokemon


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
class PokemonResponse(
    private val name: String,
    private val abilities: List<String>,
    private val types: List<String>
) {
    fun getName() : String{
        return this.name
    }

    fun getAbilities() : List<String>{
        return this.abilities
    }

    fun getTypes() : List<String>{
        return this.types
    }

    companion object {
        fun fromDomain(pokemon : Pokemon) : PokemonResponse{
            return PokemonResponse(pokemon.name,
                pokemon.abilities,
                pokemon.types)
        }
    }

    override fun toString(): String {
        return "PokemonResponse(name='$name', abilities=$abilities, types=$types)"
    }
}
