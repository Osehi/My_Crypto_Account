package com.polish.mycrypto_account.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "cryptoCoin_table")
@Parcelize
data class CryptoCoin(
    @SerializedName("available_supply")
    val availableSupply: String,
    @SerializedName("24h_volume_usd")
    val hVolumeUsd: String,

    @PrimaryKey
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("market_cap_usd")
    val marketCapUsd: String,
    @SerializedName("max_supply")
    val maxSupply: String,
    val name: String,
    @SerializedName("percent_change_1h")
    val percentChange1h: String,
    @SerializedName("percent_change_24h")
    val percentChange24h: String,
    @SerializedName("percent_change_7d")
    val percentChange7d: String,
    @SerializedName("price_btc")
    val priceBtc: String,
    @SerializedName("price_usd")
    val priceUsd: String,
    val rank: String,
    val symbol: String,
    @SerializedName("total_supply")
    val totalSupply: String
):Parcelable