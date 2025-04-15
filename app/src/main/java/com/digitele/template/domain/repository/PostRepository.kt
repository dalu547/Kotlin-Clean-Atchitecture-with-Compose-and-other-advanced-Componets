package com.digitele.template.domain.repository

import Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}