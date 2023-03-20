package com.ozancanguz.motivate_me_app.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.motivate_me_app.data.repository.Repository
import com.ozancanguz.motivate_me_app.data.models.Quote
import com.ozancanguz.motivate_me_app.data.models.quote2.Quote2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {

    var quote=MutableLiveData<Quote2>()

    fun getQuote(){
        viewModelScope.launch {
            val response=repository.remote.getQuote()
            if(response.isSuccessful){
                quote.postValue(response.body())
            }else{
                Log.d("quoteviewmodel","No data for quote")
            }
        }
    }


}