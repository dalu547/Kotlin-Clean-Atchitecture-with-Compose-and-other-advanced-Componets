package com.digitele.template.data.datasource.remote

import com.digitele.template.data.model.PostDto
import retrofit2.http.GET

interface MyApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}