package org.redbee.application.port.out

import org.redbee.application.usecase.model.Pokemon

interface CreatePokemonRepository {

    fun execute(pokemon : Pokemon) : Pokemon
}