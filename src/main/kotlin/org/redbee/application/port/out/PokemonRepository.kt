package org.redbee.application.port.out

import org.redbee.application.usecase.model.Pokemon

interface PokemonRepository {
    fun get(name: String): Pokemon
}
