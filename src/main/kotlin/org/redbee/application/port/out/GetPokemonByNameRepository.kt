package org.redbee.application.port.out

import org.redbee.application.usecase.model.Pokemon

interface GetPokemonByNameRepository {
    fun execute(name: String): Pokemon?
}
