package org.redbee.adapter.out.hibernate

import org.redbee.application.port.out.CreateDigimonRepository
import org.redbee.application.usecase.model.Digimon
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateDigimonHibernateAdapter : CreateDigimonRepository {
    override fun execute(digimon: Digimon) {
        // TODO: Implementar la funcion
    }
}
