package com.mustafa.domain.repository

import com.mustafa.domain.model.Sample
import java.util.*

interface SampleRepository {
    fun getSample(name: String, date: Date): Sample
}