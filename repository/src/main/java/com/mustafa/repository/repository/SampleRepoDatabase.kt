package com.mustafa.repository.repository

import com.mustafa.repository.model.Sample

interface SampleRepoDatabase {
    suspend fun cacheSample(sample: Sample)
    suspend fun getSample(name: String): Sample?
    suspend fun deleteSample(sample: Sample)
}