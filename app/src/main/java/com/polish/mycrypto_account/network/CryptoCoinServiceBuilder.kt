package com.polish.mycrypto_account.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CryptoCoinServiceBuilder {

    // this configures retrofit to parse JSON and use coroutines


    // the base-URL
    private const val URL = "https://api.coinmarketcap.com/v1/"

    // create a retrofit builder
    private val builder = Retrofit.Builder()
                                        .baseUrl(URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(CoroutineCallAdapterFactory())

    // create a retrofit instance
    private val retrofit = builder.build()

    // create the Api service
    fun <T> builderService(serviceType:Class<T>):T{

        return retrofit.create(serviceType)

    }


}