package com.mustafa.domain.usecase

import com.mustafa.domain.model.Sample
import com.mustafa.domain.repository.SampleRepository

class SampleUseCase(
    private val sampleRepo: SampleRepository
) : UseCaseIO<Sample, SampleUseCase.Params>() {
    override suspend fun run(params: Params): Sample {
        return sampleRepo.getSample(
            params.name
        )
    }

    data class Params(val name: String)
}