package com.digitele.template.data.repository

import Post
import com.digitele.template.data.datasource.local.PostDao
import com.digitele.template.data.datasource.remote.MyApiService
import com.digitele.template.data.model.toDomain
import com.digitele.template.data.model.toEntity
import com.digitele.template.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: MyApiService, private val dao: PostDao
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }

    override suspend fun savePostsToLocal(posts: List<Post>) {
        dao.insertPosts(posts.map { it.toEntity() })  // Mapper: Post -> PostEntity
    }

    override suspend fun getPostsFromLocal(): List<Post> {
        return dao.getAllPosts().map { it.toDomain() }  // Mapper: PostEntity -> Post
    }
}