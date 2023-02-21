package com.ozancanguz.motivate_me_app.data.remote

import com.ozancanguz.motivate_me_app.data.api.QuoteApi
import com.ozancanguz.motivate_me_app.data.models.Quote
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val quoteApi: QuoteApi) {

    suspend fun getQuote(): Response<Quote> {
        return quoteApi.getQuote()
    }
}