package com.mustafa.database.di

import com.mustafa.database.source.AppDb
import com.mustafa.database.source.SampleRepoDatabaseImpl
import com.mustafa.repository.repository.SampleRepoDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseSampleModule = module {

    single<SampleRepoDatabase> {
        AppDb.initDb(androidContext())
        SampleRepoDatabaseImpl()
    }

}