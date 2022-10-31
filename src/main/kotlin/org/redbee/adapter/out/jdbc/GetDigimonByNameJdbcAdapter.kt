package org.redbee.adapter.out.jdbc

import org.redbee.application.port.out.GetDigimonByNameRepository
import org.redbee.application.usecase.model.Digimon

class GetDigimonByNameJdbcAdapter : GetDigimonByNameRepository {
    override fun execute(name: String): Digimon {

        return Digimon("vamo a", "calmarnos")
    }
}