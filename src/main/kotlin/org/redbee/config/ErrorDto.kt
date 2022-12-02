package org.redbee.config

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
interface ErrorDto {
    val code: String
}
