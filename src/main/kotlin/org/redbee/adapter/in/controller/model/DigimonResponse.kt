package org.redbee.adapter.`in`.controller.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.redbee.application.usecase.model.Digimon

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
class DigimonResponse(
    private val name: String,
    private val level: String,
) {
    fun getName() : String{
        return this.name
    }
    fun getLevel() : String{
        return this.level
    }

    companion object {
        fun fromDomain(digimon : Digimon) : DigimonResponse{
            return DigimonResponse(digimon.getName(),
                digimon.getLevel())
        }
    }

    override fun toString(): String {
        return "DigimonResponse(name='$name', level='$level')"
    }
}
