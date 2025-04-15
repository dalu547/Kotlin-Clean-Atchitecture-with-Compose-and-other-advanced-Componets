package com.digitele.template.data.model

import Post

 fun PostDto.toDomain(): Post {
        return Post(
            id = id,
            title = title,
            body = body
        )
    }
