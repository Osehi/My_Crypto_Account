package com.polish.mycrypto_account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycrypto_account.databinding.FavouritecoinItemBinding
import com.polish.mycrypto_account.model.CryptoCoin

class FavouriteCoinAdapter(val onClickListener:OnClickListener): ListAdapter<CryptoCoin, FavouriteCoinAdapter.FavouriteCoinViewHolder>(DiffCallback) {

    class FavouriteCoinViewHolder(var binding: FavouritecoinItemBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(cryptoCoin: CryptoCoin){
            binding.cryptoCoin = cryptoCoin

            binding.executePendingBindings()

        }


    }

    companion object DiffCallback :DiffUtil.ItemCallback<CryptoCoin>(){
        override fun areItemsTheSame(oldItem: CryptoCoin, newItem: CryptoCoin): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CryptoCoin, newItem: CryptoCoin): Boolean {
           return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteCoinAdapter.FavouriteCoinViewHolder {
        return FavouriteCoinViewHolder(FavouritecoinItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: FavouriteCoinAdapter.FavouriteCoinViewHolder,
        position: Int
    ) {
        val favouredCryptoCoin = getItem(position)

        holder.itemView.setOnClickListener {
           onClickListener.onClick(favouredCryptoCoin)
        }

        holder.bind(favouredCryptoCoin)


    }

    class OnClickListener(val clickListener:(cryptoCoin:CryptoCoin) -> Unit){
        fun onClick(cryptoCoin:CryptoCoin) = clickListener(cryptoCoin)
    }

}