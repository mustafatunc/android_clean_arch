package com.mustafa.database.mapper

import com.mustafa.database.model.SampleEntity
import com.mustafa.repository.model.Sample
import java.util.*

internal fun SampleEntity.toRepo(): Sample{
    return Sample(
        this.name,
        this.count,
        Date(this.dateAdded),
        this.expires
    )
}

internal fun Sample.toDb(): SampleEntity{
    return SampleEntity(
        this.sampleName,
        this.sampleCount,
        this.sampleDate.time,
        this.sampleExpirationDate
    )
}