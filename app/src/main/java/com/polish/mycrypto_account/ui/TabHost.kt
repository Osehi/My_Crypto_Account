package com.polish.mycrypto_account.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.polish.mycrypto_account.R
import com.polish.mycrypto_account.adapter.TabHostAdapter

/**
 * A simple [Fragment] subclass.
 */
class TabHost : Fragment() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_tab_host, container, false)

        viewPager = view.findViewById(R.id.viewPagerId)
        tabLayout = view.findViewById(R.id.tablayoutId)

        //setup the adapter
        val fragAdapter = TabHostAdapter(childFragmentManager)
        viewPager.adapter = fragAdapter

        // connect the tablayout to the viewPage
        tabLayout.setupWithViewPager(viewPager)


        return view
    }


}
