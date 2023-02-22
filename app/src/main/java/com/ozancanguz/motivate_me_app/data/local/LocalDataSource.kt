package com.ozancanguz.motivate_me_app.data.local

import androidx.lifecycle.LiveData
import com.ozancanguz.motivate_me_app.data.models.diary.Diary
import com.ozancanguz.motivate_me_app.data.models.diary.DiaryDao
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val diaryDao: DiaryDao) {


    // get all data from dao
    val getAllData:LiveData<List<Diary>> =diaryDao.getAllData()

    // insert data to repository
    suspend fun insertData(diary: Diary){
        return diaryDao.insertData(diary)
    }


    // delete single item
    suspend fun deleteSingleItem(diary: Diary){
        return diaryDao.deleteSingleItem(diary)
    }



}