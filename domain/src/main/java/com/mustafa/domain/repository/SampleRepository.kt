package com.mustafa.domain.repository

import com.mustafa.domain.exception.BaseException
import com.mustafa.domain.model.Sample

interface SampleRepository {
    @Throws(BaseException::class)
    suspend fun getSample(name: String): Sample
}