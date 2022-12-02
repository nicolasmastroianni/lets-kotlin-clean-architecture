package org.redbee.adapter.out.hibernate

import org.redbee.application.port.out.GetDigimonByNameRepository
import org.redbee.application.usecase.model.Digimon
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetDigimonByNameHibernateAdapter(
    /*private val entityManager: EntityManager*/
) : GetDigimonByNameRepository {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(name: String): Digimon {
      /*  log.info("Obteniendo digimon con nombre: $name")

        val digimonResult: DigimonHibernateModel = this.entityManager.createNativeQuery(
            "select name, levels from digimon where name = :NAME", DigimonHibernateModel::class.java)
            .setParameter("NAME", name)
            .singleResult as DigimonHibernateModel

        val digimon = digimonResult.toDomain()
        log.info("Digimon obtenido: ${digimon}")

        return digimon*/
        return Digimon("", "")
    }
}
