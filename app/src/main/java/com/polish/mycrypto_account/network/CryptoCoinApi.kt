package com.polish.mycrypto_account.network

import com.polish.mycrypto_account.model.CryptoCoin
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCoinApi {

    @GET("ticker")
    fun getCryptoCoinRes(@Query("limit") limit:Int):Deferred<List<CryptoCoin>>

}