package com.mustafa.network.source

import android.util.Log
import com.mustafa.network.mapper.toRepo
import com.mustafa.repository.model.Sample
import com.mustafa.repository.repository.SampleRepoNetwork

internal class SampleRepoNetworkImpl : SampleRepoNetwork {
    private val api = DtoProvider.getInstance().getSampleDto()

    @Throws(Exception::class)
    override suspend fun fetchSample(): Sample {
        Log.d("SampleRepoNetworkImpl", "Fetching...")
        return api.getSample().toRepo()
    }
}