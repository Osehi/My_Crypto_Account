package com.polish.mycrypto_account.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.polish.mycrypto_account.model.CryptoCoin

@Database(entities = [CryptoCoin::class], version = 2, exportSchema = false)
abstract class FavouriteCoinDatabase: RoomDatabase() {


    abstract fun favouriteCoinDao(): FavouriteCoinDao

    companion object {

        @Volatile
        private var INSTANCE:FavouriteCoinDatabase? = null
        fun getInstance(context: Context):FavouriteCoinDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavouriteCoinDatabase::class.java,
                        "favouriteCoin_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}