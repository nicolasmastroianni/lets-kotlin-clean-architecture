package org.redbee.adapter.out.hibernate

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.redbee.adapter.exception.NotAvailableException
import org.redbee.adapter.exception.NotFoundException
import org.redbee.adapter.exception.UnprocessableException
import org.redbee.adapter.out.hibernate.model.PokemonHibernateModel
import org.redbee.adapter.out.hibernate.utils.FileReader
import org.redbee.application.port.out.GetPokemonByNameRepository
import org.redbee.application.usecase.model.Pokemon
import org.redbee.shared.error.model.ErrorDescription
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named
import javax.persistence.EntityExistsException
import javax.persistence.LockTimeoutException
import javax.persistence.NoResultException
import javax.persistence.QueryTimeoutException

@Named("pokemonResource")
@ApplicationScoped
class GetPokemonByNameHibernateAdapter(
    private val getPokemonByName: String = FileReader.execute("sql/getPokemonByName.sql")
) : GetPokemonByNameRepository, PanacheRepository<PokemonHibernateModel> {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Pokemon {
        try {
            log.info("Obteniendo pokemon con nombre: $name")
            val pokemonResult = this.getEntityManager()
                .createNativeQuery(getPokemonByName, PokemonHibernateModel::class.java)
                .setParameter("NAME", name)
                .singleResult as PokemonHibernateModel
            log.info("Pokemon obtenido: $pokemonResult")

            return pokemonResult.toDomain()
        } catch (exception: NoResultException) {
            throw NotFoundException(ErrorDescription.NOT_FOUND.value)
        } catch (exception: QueryTimeoutException) {
            throw NotAvailableException(ErrorDescription.TIMEOUT.value)
        } catch (exception: LockTimeoutException) {
            throw NotAvailableException(ErrorDescription.TIMEOUT.value)
        } catch (exception: EntityExistsException) {
            throw UnprocessableException(ErrorDescription.DUPLICATED.value)
        }
    }
}
