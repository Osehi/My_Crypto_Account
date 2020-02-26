package com.polish.mycrypto_account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycrypto_account.databinding.AllcoinItemBinding
import com.polish.mycrypto_account.model.CryptoCoin

class AllCoinAdapter(val onclickListener:OnClickListener):androidx.recyclerview.widget.ListAdapter<CryptoCoin,AllCoinAdapter.CryptoCoinAllViewHolder>(DifffCallback){

    class CryptoCoinAllViewHolder(var binding:AllcoinItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoCoin:CryptoCoin){
            binding.cryptoCoin = cryptoCoin

            binding.executePendingBindings()
        }
    }


    companion object DifffCallback:DiffUtil.ItemCallback<CryptoCoin>(){
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
    ): AllCoinAdapter.CryptoCoinAllViewHolder {
        return CryptoCoinAllViewHolder(
            AllcoinItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: AllCoinAdapter.CryptoCoinAllViewHolder, position: Int) {

        val cryptoCoin = getItem(position)

        holder.itemView.setOnClickListener {
            onclickListener.onClick(cryptoCoin)
        }

        holder.bind(cryptoCoin)

    }

    class OnClickListener(val clickListener:(cryptoCoin:CryptoCoin) -> Unit){
        fun onClick(cryptoCoin:CryptoCoin) = clickListener(cryptoCoin)
    }


}