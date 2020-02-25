package com.polish.mycrypto_account.repository

import android.app.Application
import com.polish.mycrypto_account.database.FavouriteCoinDao
import com.polish.mycrypto_account.database.FavouriteCoinDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class FavouriteCoinRepository(application: Application):CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var favouriteCoinDao:FavouriteCoinDao


    init {

        val database = FavouriteCoinDatabase.getInstance(application)

        favouriteCoinDao = database.favouriteCoinDao()

    }




}