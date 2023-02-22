package com.ozancanguz.motivate_me_app.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.motivate_me_app.data.models.diary.DiaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DiaryDatabase::class.java,
        "diary_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: DiaryDatabase) = database.diaryDao()

}