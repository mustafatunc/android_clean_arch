package com.mustafa.repository.model

import java.util.*

data class Sample(
    val sampleName: String,
    val sampleCount: Int,
    val sampleDate: Date,
    val sampleExpirationDate: Long
)