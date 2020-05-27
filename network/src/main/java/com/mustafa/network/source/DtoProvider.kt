package com.mustafa.network.source

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.mustafa.network.dto.SampleDto
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DtoProvider private constructor(context: Context) {

    private val retrofit: Retrofit

    init {
        Log.d("DtoProvider","Initializing retrofit")
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.mysamples.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
    }


    companion object {
        private var providerInstance: DtoProvider? = null

        fun createInstance(context: Context) {
            if (providerInstance == null) {
                providerInstance = DtoProvider(context)
            }
        }

        fun getInstance(): DtoProvider {
            return providerInstance ?: throw Exception("Network module has not been initialized")
        }
    }

    internal fun getSampleDto() = retrofit.create(SampleDto::class.java)


}