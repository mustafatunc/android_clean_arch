package com.mustafa.network.di

import com.mustafa.network.source.DtoProvider
import com.mustafa.network.source.SampleRepoNetworkImpl
import com.mustafa.repository.repository.SampleRepoNetwork
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkSampleModule = module {

    single<SampleRepoNetwork> {
        DtoProvider.createInstance(androidContext())
        SampleRepoNetworkImpl()
    }

}