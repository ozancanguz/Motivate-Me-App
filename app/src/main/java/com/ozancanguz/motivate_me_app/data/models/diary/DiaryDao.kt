package com.ozancanguz.motivate_me_app.data.models.diary

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DiaryDao {


    // get all diary from db
    @Query("select * from diary_table order by id Asc")
    fun getAllData(): LiveData<List<Diary>>


    // insert diary
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(diary: Diary)


    // delete single item
    @Delete
    suspend fun deleteSingleItem(diary: Diary)

}

