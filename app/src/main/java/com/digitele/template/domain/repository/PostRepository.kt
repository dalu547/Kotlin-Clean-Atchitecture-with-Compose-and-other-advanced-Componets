package com.digitele.template.domain.repository

import Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun savePostsToLocal(posts: List<Post>)
    suspend fun getPostsFromLocal(): List<Post>
}