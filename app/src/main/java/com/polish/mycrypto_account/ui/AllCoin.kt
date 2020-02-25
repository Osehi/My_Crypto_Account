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
import com.polish.mycrypto_account.adapter.AllCoinAdapter
import com.polish.mycrypto_account.databinding.FragmentAllCoinBinding
import com.polish.mycrypto_account.viewModel.AllCoinViewModel

/**
 * A simple [Fragment] subclass.
 */
class AllCoin : Fragment() {

    private lateinit var allCoinViewModel:AllCoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_all_coin, container, false)

        // inflate fragment using binding
        val binding = FragmentAllCoinBinding.inflate(inflater, container, false)

        allCoinViewModel = ViewModelProvider(this).get(AllCoinViewModel::class.java)

        val recyclerView = binding.recyclerViewAllCoinId
        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = AllCoinAdapter(AllCoinAdapter.OnClickListener{

        })

        recyclerView.adapter = adapter

        allCoinViewModel.allCoin.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })


        return binding.root
    }


}
