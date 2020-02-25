package com.polish.mycrypto_account.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.polish.mycrypto_account.model.CryptoCoin

@Dao
interface FavouriteCoinDao {

    @Insert
    fun insertFavouritCoin(cryptoCoin: CryptoCoin)

    @Delete
    fun deleteFavouriteCoin(cryptoCoin: CryptoCoin)

    @Query("SELECT * FROM cryptoCoin_table ORDER BY id DESC")
    fun getAllFavouriteCoin(): LiveData<List<CryptoCoin>>


}