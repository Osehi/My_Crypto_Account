package com.polish.mycrypto_account.repository

import android.util.Log
import com.polish.mycrypto_account.model.CryptoCoin
import com.polish.mycrypto_account.network.CryptoCoinApi
import com.polish.mycrypto_account.network.CryptoCoinServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

const val LIMIT_SIZE = 50

object AllCryptoCoinRepository {

    val cryptoCoinApiService = CryptoCoinServiceBuilder.builderService(CryptoCoinApi::class.java)

    suspend fun getCryptoCoinResponse():List<CryptoCoin>{
        var data = listOf<CryptoCoin>()
        withContext(Dispatchers.IO){
            Log.e("CHECK", "calling:${data}")
            try {
                Log.e("TRY CALL", "try")
                data = cryptoCoinApiService.getCryptoCoinRes(LIMIT_SIZE).await()
                println(data)

                Log.e("NETWORK CALL", "${data}")
//                Log.i("CALLING", "Grace, Grace")


            } catch (t:Throwable){
                Log.e("ERROR",t.message)
            }
        }
        return data
    }

}