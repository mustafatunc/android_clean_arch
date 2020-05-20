package com.mustafa.domain.repository

import com.mustafa.domain.model.Sample

interface SampleRepository {
    suspend fun getSample(name: String): Sample
}