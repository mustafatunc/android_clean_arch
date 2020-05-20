package com.mustafa.database.source

import com.mustafa.database.mapper.toDb
import com.mustafa.database.mapper.toRepo
import com.mustafa.repository.mapper.toDomain
import com.mustafa.repository.model.Sample
import com.mustafa.repository.repository.SampleRepoDatabase

internal class SampleRepoDatabaseImpl: SampleRepoDatabase{
    private val dao = AppDb.getDb().getSampleDao()

    override suspend fun cacheSample(sample: Sample) {
        dao.addSample(sample.toDb())
    }

    override suspend fun getSample(name: String): Sample? {
        return dao.getSample(name)?.toRepo()
    }

    override suspend fun deleteSample(sample: Sample) {
        dao.removeSample(sample.toDb())
    }
}