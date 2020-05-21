package com.mustafa.network.mapper

import com.mustafa.network.model.Sample
import java.util.*
import com.mustafa.repository.model.Sample as SampleRepo

internal fun Sample.toRepo(): SampleRepo{
    return SampleRepo(
        this.name,
        this.count,
        Date(System.currentTimeMillis()),
        this.expiresAfter
    )
}