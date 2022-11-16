package org.redbee.adapter.out.rest.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.quarkus.runtime.annotations.RegisterForReflection
import org.redbee.application.usecase.model.Pokemon
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
data class PokemonRestModel(
     val name: String = "",
     val abilities: List<AbilityInformationRestModel> = Collections.emptyList(),
     val types: List<TypeInformationRestModel> = Collections.emptyList()
) {

    fun toDomain() : Pokemon {
        return Pokemon(name,
            abilities.map { a -> a.ability.name },
            types.map { t -> t.type.name }
        )
    }
}
