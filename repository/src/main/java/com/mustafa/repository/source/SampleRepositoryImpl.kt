package com.mustafa.repository.source

import android.util.Log
import com.mustafa.domain.exception.BaseException
import com.mustafa.domain.model.Sample
import com.mustafa.domain.repository.SampleRepository
import com.mustafa.repository.mapper.toDomain
import com.mustafa.repository.repository.SampleRepoDatabase
import com.mustafa.repository.repository.SampleRepoNetwork
import java.util.*

class SampleRepositoryImpl(
    private val network: SampleRepoNetwork,
    private val cache: SampleRepoDatabase
) : SampleRepository {

    private val TAG = this::class.java.simpleName

    @Throws(BaseException::class)
    override suspend fun getSample(name: String): Sample {
        try {

            val cachedSample = cache.getSample(name)
            if (cachedSample == null) {
                Log.d(TAG, "cachedSample is null")
                Log.d(TAG, "calling network fetch sample")
                val fetchedSample = network.fetchSample()
                Log.d(TAG, "calling cache sample")
                cache.cacheSample(fetchedSample)
                Log.d(TAG, "returning fetched sample")
                return fetchedSample.toDomain()
            }

            return if (isExpired(cachedSample.sampleDate)) {
                Log.d(TAG, "sample has expired")
                Log.d(TAG, "fetching sample")
                val fetchedSample = network.fetchSample()
                Log.d(TAG, "deleting sample from cache")
                cache.deleteSample(cachedSample)
                Log.d(TAG, "caching new sample")
                cache.cacheSample(fetchedSample)
                Log.d(TAG, "returning fetched sample")
                fetchedSample
            } else {
                Log.d(TAG, "Sample has NOT expired, returning cached sample")
                cachedSample
            }.toDomain()
        } catch (e: Exception) {
            throw BaseException(e.message ?: "no message - ${e.javaClass.simpleName}")
        }
    }

    private fun isExpired(date: Date): Boolean {
        // Some calculations here
        return true
    }

}