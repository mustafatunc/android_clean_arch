package com.mustafa.network.source

import android.content.Context
import com.mustafa.network.dto.SampleDto
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.lang.Exception


class DtoProvider private constructor(context: Context) {

    private val retrofit: Retrofit

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.mysamples.com/")
            .client(client)
            .build()
    }


    companion object {
        private var providerInstance: DtoProvider? = null

        fun createInstance(context: Context) {
            if (providerInstance != null) {
                providerInstance = DtoProvider(context)
            }
        }

        fun getInstance(): DtoProvider {
            if(providerInstance == null){
                throw Exception("Network module has not been initialized")
            }
            return providerInstance!!
        }
    }

    internal fun getSampleDto() = retrofit.create(SampleDto::class.java)


}