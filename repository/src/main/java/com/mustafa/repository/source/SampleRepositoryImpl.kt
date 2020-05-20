package com.mustafa.repository.source

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
    override suspend fun getSample(name: String): Sample {
        val cachedSample = cache.getSample(name)
        if (cachedSample == null) {
            val fetchedSample = network.fetchSample()
            cache.cacheSample(fetchedSample)
            return fetchedSample.toDomain()
        }

        return if (isExpired(cachedSample.sampleDate)) {
            val fetchedSample = network.fetchSample()
            cache.deleteSample(cachedSample)
            cache.cacheSample(fetchedSample)
            fetchedSample
        } else {
            cachedSample
        }.toDomain()

    }

    private fun isExpired(date: Date): Boolean {
        // Some calculations here
        return true
    }

}