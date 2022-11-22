package com.payway.bin_validator.model

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
interface ErrorDto {
	val code: String
}
