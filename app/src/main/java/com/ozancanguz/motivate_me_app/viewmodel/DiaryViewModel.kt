package com.ozancanguz.motivate_me_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.motivate_me_app.data.models.diary.Diary
import com.ozancanguz.motivate_me_app.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel@Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {



    //get all data list
    val getAllData: LiveData<List<Diary>>

    // init get all data
    init {
        getAllData=repository.local.getAllData
    }

    // inserting data with background thread
    fun insertData(diary: Diary){
        viewModelScope.launch(Dispatchers.IO){
            repository.local.insertData(diary)
        }
    }
}