package org.redbee.application.usecase.model

data class Pokemon(
    val name: String,
    val abilities: List<String>,
    val types: List<String>
)
