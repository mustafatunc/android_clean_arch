package com.mustafa.domain.usecase

import com.mustafa.domain.model.Sample
import com.mustafa.domain.repository.SampleRepository
import java.util.*

class SampleUseCase(
    private val sampleRepo: SampleRepository
) : UseCaseIO<Sample, SampleUseCase.Params>() {
    override suspend fun run(params: Params): Sample {
        return sampleRepo.getSample(
            params.name,
            params.date
        )
    }

    data class Params(val name: String, val date: Date)
}