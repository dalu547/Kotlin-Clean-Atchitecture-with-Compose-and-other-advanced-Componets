package com.digitele.template.data.repository

import Post
import com.digitele.template.data.datasource.remote.MyApiService
import com.digitele.template.data.model.toDomain
import com.digitele.template.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: MyApiService
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }
}