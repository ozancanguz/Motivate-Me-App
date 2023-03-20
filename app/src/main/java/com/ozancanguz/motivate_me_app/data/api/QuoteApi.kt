package com.ozancanguz.motivate_me_app.data.api

import com.ozancanguz.motivate_me_app.data.models.Quote
import com.ozancanguz.motivate_me_app.data.models.quote2.Quote2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteApi {



    @GET("api/quotes")
    suspend fun getQuote(): Response<Quote2>

}