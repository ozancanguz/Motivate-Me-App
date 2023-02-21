package com.ozancanguz.motivate_me_app.data.repository

import com.ozancanguz.motivate_me_app.data.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource) {
    val remote=remoteDataSource
}