package org.redbee.adapter.out.hibernate.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.quarkus.runtime.annotations.RegisterForReflection
import org.redbee.application.usecase.model.Digimon
import java.util.*

@RegisterForReflection
data class DigimonHibernateModel(
    val name: String = "",
    val levels : String = ""
) {

    fun toDomain() : Digimon {
        return Digimon(name, levels)
    }
}

