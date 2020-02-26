package com.polish.mycrypto_account.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.databinding.FragmentCryptoCoinDetailsBinding
import com.polish.mycrypto_account.model.CryptoCoin
import com.polish.mycrypto_account.viewModel.FavouriteCoinViewModel

/**
 * A simple [Fragment] subclass.
 */
class CryptoCoinDetails : Fragment() {

    // a viewModel object variable
    lateinit var favouriteCoinViewModel:FavouriteCoinViewModel

    // an object variable to hold the arguements
    var cryptoCoin:CryptoCoin? = null

    // receive the argument
    val args:CryptoCoinDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_crypto_coin_details, container, false)

        val binding = FragmentCryptoCoinDetailsBinding.inflate(inflater, container, false)

        // get an instance of this viewModel
        favouriteCoinViewModel = ViewModelProvider(this).get(FavouriteCoinViewModel::class.java)

        // receive the arguement here
        cryptoCoin = args.CryptoCoin

        binding.cryptoCoin = cryptoCoin

        binding.addFavouriteId.setOnClickListener {

            favouriteCoinViewModel.insertFavouriteCoin(cryptoCoin!!)

        }

        return binding.root

    }

}
