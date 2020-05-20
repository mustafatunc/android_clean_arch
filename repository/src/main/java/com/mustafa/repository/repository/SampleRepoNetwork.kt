package com.mustafa.repository.repository

import com.mustafa.repository.model.Sample


interface SampleRepoNetwork {
    suspend fun fetchSample(): Sample
}