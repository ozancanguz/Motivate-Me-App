package com.ozancanguz.motivate_me_app.data.models.diary

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    var gson = Gson()

    @androidx.room.TypeConverter
    fun ProductToString(diary: Diary): String {
        return gson.toJson(diary)
    }

    @androidx.room.TypeConverter
    fun stringToProducts(data: String): Diary {
        val listType = object : TypeToken<Diary>() {}.type
        return gson.fromJson(data, listType)
    }
}