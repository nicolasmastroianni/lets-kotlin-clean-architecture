package org.redbee.adapter.out.hibernate

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.redbee.adapter.out.hibernate.model.PokemonHibernateModel
import org.redbee.adapter.out.hibernate.utils.FileReader
import org.redbee.application.port.out.PokemonRepository
import org.redbee.application.usecase.model.Pokemon
import org.slf4j.LoggerFactory
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@Named("pokemonResource")
@ApplicationScoped
class GetPokemonByNameHibernateAdapter(
    private val getPokemonByName: String = FileReader.execute("getPokemonByName.sql")
) : PokemonRepository, PanacheRepository<PokemonHibernateModel> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun get(name: String): Pokemon {
        log.info("Obteniendo pokemon con nombre: $name")
        val pokemonResult = this.getEntityManager()
            .createNativeQuery(getPokemonByName, PokemonHibernateModel::class.java)
            .setParameter("NAME", name)
            .singleResult as PokemonHibernateModel

        log.info("Pokemon obtenido: ${pokemonResult}")

        if (pokemonResult == null) {
            throw Exception("Not found")
        }
        return pokemonResult.toDomain()

    }
}