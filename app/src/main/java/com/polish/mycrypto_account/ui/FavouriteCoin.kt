package com.polish.mycrypto_account.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.adapter.FavouriteCoinAdapter
import com.polish.mycrypto_account.databinding.FragmentFavouriteCoinBinding
import com.polish.mycrypto_account.model.CryptoCoin
import com.polish.mycrypto_account.viewModel.FavouriteCoinViewModel

/**
 * A simple [Fragment] subclass.
 */
class FavouriteCoin : Fragment() {



    lateinit var favouriteCoinViewModel: FavouriteCoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_favourite_coin, container, false)

        // inflate the layout via binding
        val binding = FragmentFavouriteCoinBinding.inflate(inflater, container, false)

        // create an instance of the viewModel
        favouriteCoinViewModel = ViewModelProvider(this).get(FavouriteCoinViewModel::class.java)

        // connect the recyclerView to the adapter
        val recyclerView = binding.recyclerViewFavouriteCoinId
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = FavouriteCoinAdapter(FavouriteCoinAdapter.OnClickListener{CryptoCoin ->
            val action = TabHostDirections.actionTabHost2ToDetailsFavouriteCoin(CryptoCoin)
            findNavController().navigate(action)
        })

        recyclerView.adapter = adapter

        favouriteCoinViewModel.allFavouriteCoin.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        // swipe to left to delete item-list
        ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val mAlertDialog = AlertDialog.Builder(viewHolder.itemView.context)
                mAlertDialog.setTitle("Remove CryptoCoin")
                mAlertDialog.setMessage("This wil be removed from your favourite coin ")
                mAlertDialog.setPositiveButton("Delete"){
                    dialog, which ->
                    val cryptoCoin = adapter.currentList.get(viewHolder.adapterPosition)
                    favouriteCoinViewModel.deleteFavouriteCoin(cryptoCoin)
                    Toast.makeText(context, "Favourite coin deleted", Toast.LENGTH_SHORT ).show()
                }
                mAlertDialog.setNegativeButton("Cancel"){
                    dialog, which ->
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
                mAlertDialog.show()


            }
        }).attachToRecyclerView(binding.recyclerViewFavouriteCoinId)



        return binding.root

    }


}
