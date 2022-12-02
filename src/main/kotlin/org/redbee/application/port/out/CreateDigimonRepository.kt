package org.redbee.application.port.out

import org.redbee.application.usecase.model.Digimon

interface CreateDigimonRepository {
    fun execute(digimon : Digimon)

}
