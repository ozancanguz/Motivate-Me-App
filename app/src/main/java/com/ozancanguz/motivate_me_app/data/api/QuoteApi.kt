package com.ozancanguz.motivate_me_app.data.api

import com.ozancanguz.motivate_me_app.data.models.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteApi {

    @Headers("Authorization: Bearer 844|nHc5uSAr948kWrcy1fFkfVqlIRGpvBMkYMjQgBdi")
    @GET("get+a+quote")
    suspend fun getQuote(): Response<Quote>

}