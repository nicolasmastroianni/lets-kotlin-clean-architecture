package com.payway.bin_validator.model

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class DefaultErrorDto(
	override val code: String,
	val message: String,
): ErrorDto
