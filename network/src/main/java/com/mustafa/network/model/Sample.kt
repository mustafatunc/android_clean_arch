package com.mustafa.network.model

import com.google.gson.annotations.SerializedName

internal data class Sample(
    @SerializedName("sample_name")
    val name: String,
    @SerializedName("sample_count")
    val count: Int,
    @SerializedName("expires")
    val expiresAfter: Long
)