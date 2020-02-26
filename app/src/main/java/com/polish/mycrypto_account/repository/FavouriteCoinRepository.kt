package com.polish.mycrypto_account.repository

import android.app.Application
import com.polish.mycrypto_account.database.FavouriteCoinDao
import com.polish.mycrypto_account.database.FavouriteCoinDatabase
import com.polish.mycrypto_account.model.CryptoCoin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FavouriteCoinRepository(application: Application):CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var favouriteCoinDao:FavouriteCoinDao


    init {

        val database = FavouriteCoinDatabase.getInstance(application)

        favouriteCoinDao = database.favouriteCoinDao()

    }


    fun getAllFavouriteCoin() = favouriteCoinDao.getAllFavouriteCoin()


    fun insertFavouriteCoin(cryptoCoin: CryptoCoin){
        launch {
            insertFavouriteCoinOffUiThread(cryptoCoin)
        }
    }


    fun deleteFavouriteCoin(cryptoCoin: CryptoCoin){
        launch {
            deleteFavouriteCoinOffUiThread(cryptoCoin)
        }
    }

    private suspend fun insertFavouriteCoinOffUiThread(cryptoCoin: CryptoCoin){
        withContext(Dispatchers.IO){
            favouriteCoinDao.insertFavouritCoin(cryptoCoin)
        }
    }


    private suspend fun deleteFavouriteCoinOffUiThread(cryptoCoin: CryptoCoin){
        withContext(Dispatchers.IO){
            favouriteCoinDao.deleteFavouriteCoin(cryptoCoin)
        }
    }





}