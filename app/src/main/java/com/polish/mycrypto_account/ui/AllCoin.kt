package com.polish.mycrypto_account.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.databinding.FragmentAllCoinBinding

/**
 * A simple [Fragment] subclass.
 */
class AllCoin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_all_coin, container, false)

        // inflate fragment using binding
        val binding = FragmentAllCoinBinding.inflate(inflater, container, false)


        return binding.root
    }


}
