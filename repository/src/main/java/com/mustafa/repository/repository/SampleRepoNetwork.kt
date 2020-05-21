package com.mustafa.repository.repository

import com.mustafa.repository.model.Sample

interface SampleRepoNetwork {
    @Throws(Exception::class)
    suspend fun fetchSample(): Sample
}