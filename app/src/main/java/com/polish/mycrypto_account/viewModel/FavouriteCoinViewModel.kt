package com.polish.mycrypto_account.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.polish.mycrypto_account.model.CryptoCoin
import com.polish.mycrypto_account.repository.FavouriteCoinRepository

class FavouriteCoinViewModel(application: Application): AndroidViewModel(application) {

    private var repository = FavouriteCoinRepository(application)

    val allFavouriteCoin = repository.getAllFavouriteCoin()



    fun insertFavouriteCoin(cryptoCoin: CryptoCoin){
        repository.insertFavouriteCoin(cryptoCoin)
    }


    fun deleteFavouriteCoin(cryptoCoin: CryptoCoin){
        repository.deleteFavouriteCoin(cryptoCoin)
    }

}