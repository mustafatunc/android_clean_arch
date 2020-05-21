package com.mustafa.database.source

import android.util.Log
import com.mustafa.database.mapper.toDb
import com.mustafa.database.mapper.toRepo
import com.mustafa.repository.model.Sample
import com.mustafa.repository.repository.SampleRepoDatabase

internal class SampleRepoDatabaseImpl: SampleRepoDatabase{
    private val dao = AppDb.getDb().getSampleDao()
    private val TAG = "SampleRepoDatabaseImpl"
    override suspend fun cacheSample(sample: Sample) {
        Log.d(TAG, "Caching..")
        dao.addSample(sample.toDb())
    }

    override suspend fun getSample(name: String): Sample? {
        Log.d(TAG, "Getting sample..")
        return dao.getSample(name)?.toRepo()?.also {
            Log.d(TAG, "Got Sample: ${it.sampleName}")
        }
    }

    override suspend fun deleteSample(sample: Sample) {
        Log.d(TAG, "Deleting..")
        dao.removeSample(sample.toDb())
    }
}