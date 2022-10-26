package org.redbee.adapter.`in`.controller.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
class DigimonRequest(
    private var name: String
) {
    fun getName() : String{
        return this.name
    }

    fun setName(name : String) : Unit {
        this.name = name
    }

    override fun toString(): String {
        return "DigimonRequest(name='$name')"
    }
}
