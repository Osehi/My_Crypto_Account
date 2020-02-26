package com.polish.mycrypto_account.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.polish.mycrypto_account.model.CryptoCoin
import com.polish.mycrypto_account.repository.AllCryptoCoinRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AllCoinViewModel(application: Application):AndroidViewModel(application) {

    private val repository = AllCryptoCoinRepository


    // create a coroutinescope
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private var _allCoin = MutableLiveData<List<CryptoCoin>>()
    val allCoin
    get() = _allCoin


    init {

        getDataFromRepository()

    }


    private fun getDataFromRepository(){

        viewModelScope.launch {
            _allCoin.value = repository.getCryptoCoinResponse()
        }

    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob
    }


}