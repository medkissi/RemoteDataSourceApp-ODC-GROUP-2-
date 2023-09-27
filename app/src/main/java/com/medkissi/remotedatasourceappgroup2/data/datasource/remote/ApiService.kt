package com.medkissi.remotedatasourceappgroup2.data.datasource.remote

import com.medkissi.remotedatasourceappgroup2.data.model.Photo
import com.medkissi.remotedatasourceappgroup2.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    suspend fun getAllPosts():List<Post>
    @GET("photos/")
    suspend fun  getAllPhotos():List<Photo>


}