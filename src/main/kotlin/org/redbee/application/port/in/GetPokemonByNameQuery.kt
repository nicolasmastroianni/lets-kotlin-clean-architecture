package org.redbee.application.port.`in`

import org.redbee.application.usecase.model.Pokemon

interface GetPokemonByNameQuery {
    fun execute(name: String): Pokemon
}
