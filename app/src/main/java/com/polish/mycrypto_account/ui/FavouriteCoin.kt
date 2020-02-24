package com.polish.mycrypto_account.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.databinding.FragmentFavouriteCoinBinding

/**
 * A simple [Fragment] subclass.
 */
class FavouriteCoin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_favourite_coin, container, false)

        // inflate the layout via binding
        val binding = FragmentFavouriteCoinBinding.inflate(inflater, container, false)

        return binding.root

    }


}
