package com.mustafa.network.source

import com.mustafa.network.mapper.toRepo
import com.mustafa.repository.model.Sample
import com.mustafa.repository.repository.SampleRepoNetwork

internal class SampleRepoNetworkImpl: SampleRepoNetwork {
    private val api = DtoProvider.getInstance().getSampleDto()

    override suspend fun fetchSample(): Sample {
        return api.getSample().toRepo()
    }
}