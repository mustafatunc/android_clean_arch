package com.mustafa.network.dto

import com.mustafa.network.model.Sample
import retrofit2.http.GET

internal interface SampleDto {

    @GET("sample")
    fun getSample(): Sample
}