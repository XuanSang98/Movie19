package com.sunasterisk.movie19.data.api

import com.sunasterisk.movie19.utils.Constants
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val httpClient = OkHttpClient.Builder().addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(Constants.NAME_API, Constants.API_KEY)
                .build()
            val requestBuilder = original.newBuilder()
                .url(url)
            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    })

    fun <T> buildService(service: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(service)
    }
}
