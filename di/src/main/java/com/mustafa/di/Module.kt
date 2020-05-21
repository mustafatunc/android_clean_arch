package com.mustafa.di

import com.mustafa.database.di.databaseSampleModule
import com.mustafa.domain.repository.SampleRepository
import com.mustafa.domain.usecase.SampleUseCase
import com.mustafa.network.di.networkSampleModule
import com.mustafa.repository.source.SampleRepositoryImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val sampleModule = module {

    loadKoinModules(
        listOf(
            networkSampleModule, databaseSampleModule
        )
    )

    single<SampleRepository> { SampleRepositoryImpl(get(), get()) }

    single { SampleUseCase(get()) }

}