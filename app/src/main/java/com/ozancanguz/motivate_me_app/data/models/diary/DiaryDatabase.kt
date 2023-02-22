package com.ozancanguz.motivate_me_app.data.models.diary

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [Diary::class], version = 1,
    exportSchema = false,)

@TypeConverters(com.ozancanguz.motivate_me_app.data.models.diary.TypeConverter::class)
abstract class DiaryDatabase: RoomDatabase(){
    abstract fun diaryDao():DiaryDao
}
