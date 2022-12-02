package org.redbee.application.port.`in`

import org.redbee.application.usecase.model.Digimon

interface GetDigimonByNameQuery {
    fun execute(name: String): Digimon
}
