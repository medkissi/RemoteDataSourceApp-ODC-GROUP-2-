package com.medkissi.remotedatasourceappgroup2.data.repository

import com.medkissi.remotedatasourceappgroup2.data.datasource.remote.ApiService
import com.medkissi.remotedatasourceappgroup2.data.model.Photo
import com.medkissi.remotedatasourceappgroup2.data.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ApiService::class.java)

  suspend fun getPosts():List<Post>{
        return service.getAllPosts()
    }


    suspend fun  getAllPhotos():List<Photo>{
        return service.getAllPhotos()
    }

}