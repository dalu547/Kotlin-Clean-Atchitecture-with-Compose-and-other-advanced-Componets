package com.digitele.template.data.model

import Post
import com.digitele.template.data.datasource.local.PostEntity

fun PostDto.toDomain(): Post {
        return Post(
            id = id,
            title = title,
            body = body
        )
    }

fun Post.toEntity(): PostEntity {
    return PostEntity(
        id = this.id,
        title = this.title,
        body = this.body
    )
}

fun PostEntity.toDomain(): Post {
    return Post(
        id = this.id,
        title = this.title,
        body = this.body
    )
}
