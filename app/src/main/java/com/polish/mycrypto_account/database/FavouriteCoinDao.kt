package com.polish.mycrypto_account.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.polish.mycrypto_account.model.CryptoCoin

@Dao
interface FavouriteCoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouritCoin(cryptoCoin: CryptoCoin)

    @Delete
    fun deleteFavouriteCoin(cryptoCoin: CryptoCoin)

    @Query("SELECT * FROM cryptoCoin_table ORDER BY id DESC")
    fun getAllFavouriteCoin(): LiveData<List<CryptoCoin>>


}