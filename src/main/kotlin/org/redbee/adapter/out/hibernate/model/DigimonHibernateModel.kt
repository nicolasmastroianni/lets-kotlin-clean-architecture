package org.redbee.adapter.out.hibernate.model

import io.quarkus.runtime.annotations.RegisterForReflection
import org.redbee.application.usecase.model.Digimon

@RegisterForReflection
data class DigimonHibernateModel(
    val name: String = "",
    val levels: String = ""
) {

    fun toDomain(): Digimon {
        return Digimon(name, levels)
    }
}
