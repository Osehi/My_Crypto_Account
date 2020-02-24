package com.polish.mycrypto_account.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.polish.mycrypto_account.ui.AllCoin
import com.polish.mycrypto_account.ui.FavouriteCoin

class TabHostAdapter(fragMngr:FragmentManager):FragmentPagerAdapter(fragMngr, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    // this set the tab positions
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                AllCoin()
            }
            else-> {
                return FavouriteCoin()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "All Coin"
            else-> {
                return "Favourite Coin"
            }
        }
    }


}