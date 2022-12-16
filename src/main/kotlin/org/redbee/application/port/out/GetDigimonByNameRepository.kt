package org.redbee.application.port.out

import org.redbee.application.usecase.model.Digimon

interface GetDigimonByNameRepository {
    fun execute(name: String): Digimon
}
