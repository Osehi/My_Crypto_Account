package com.polish.mycrypto_account.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.databinding.FragmentDetailsFavouriteCoinBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailsFavouriteCoin : Fragment() {

    val arg:DetailsFavouriteCoinArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details_favourite_coin, container, false)


        val binding = FragmentDetailsFavouriteCoinBinding.inflate(inflater, container, false)

        binding.cryptoCoin = arg.CryptoCoin

        return binding.root

    }

}
