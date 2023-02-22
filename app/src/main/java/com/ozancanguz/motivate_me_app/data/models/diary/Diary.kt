package com.ozancanguz.motivate_me_app.data.models.diary

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName ="Diary_table")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String,
    var description:String

)
