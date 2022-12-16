package org.redbee.archunit

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.Architectures

private const val ADAPTERS = "Adapters"
private const val APPLICATION = "Application"
private const val USECASE = "UseCase"
private const val PORT_IN = "Port In"
private const val SHARED = "Shared"

@AnalyzeClasses(packages = ["org.redbee"], importOptions = [ImportOption.DoNotIncludeTests::class])
class LayeredArchitectureTest {

    @ArchTest
    val layer_dependencies_are_respected: ArchRule = Architectures.layeredArchitecture()
        .layer(ADAPTERS).definedBy("org.redbee.adapter..")
        .layer(APPLICATION).definedBy("org.redbee.application..")
        .layer(USECASE).definedBy("org.redbee.application.usecase")
        .layer(PORT_IN).definedBy("org.redbee.application.port.in")
        .layer(SHARED).definedBy("org.redbee.shared..")
        .whereLayer(APPLICATION).mayOnlyBeAccessedByLayers(ADAPTERS, SHARED)
        .whereLayer(ADAPTERS).mayOnlyBeAccessedByLayers(USECASE, SHARED)
        .whereLayer(USECASE).mayOnlyBeAccessedByLayers(PORT_IN, SHARED)
}
