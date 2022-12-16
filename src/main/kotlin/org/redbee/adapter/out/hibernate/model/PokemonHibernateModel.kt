package org.redbee.adapter.out.hibernate.model

import io.quarkus.runtime.annotations.RegisterForReflection
import org.redbee.application.usecase.model.Pokemon
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pokemons")
@RegisterForReflection
data class PokemonHibernateModel(
    @Id
    @Column
    val name: String = "",
    @Column
    val ability: String = "",
    @Column
    val type: String = ""
) {

    fun toDomain(): Pokemon {
        return Pokemon(name, listOf(ability), listOf(type))
    }
}
