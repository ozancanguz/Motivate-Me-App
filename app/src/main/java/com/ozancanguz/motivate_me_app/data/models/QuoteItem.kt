package com.ozancanguz.motivate_me_app.data.models


import com.google.gson.annotations.SerializedName

data class QuoteItem(
    @SerializedName("quote")
    val quote: String
)