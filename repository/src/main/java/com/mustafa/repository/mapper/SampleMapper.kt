package com.mustafa.repository.mapper

import com.mustafa.domain.model.Sample as SampleDomain
import com.mustafa.repository.model.Sample

fun Sample.toDomain(): SampleDomain {
    return SampleDomain(
        this.sampleName,
        this.sampleCount,
        this.sampleDate
    )
}

fun List<Sample>.toDomain(): List<SampleDomain> {
    return this.map{ it.toDomain()}
}