package com.polish.mycrypto_account.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.adapter.FavouriteCoinAdapter
import com.polish.mycrypto_account.databinding.FragmentFavouriteCoinBinding
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

        var adapter = FavouriteCoinAdapter(FavouriteCoinAdapter.OnClickListener{})

        recyclerView.adapter = adapter

        favouriteCoinViewModel.allFavouriteCoin.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })



        return binding.root

    }


}
