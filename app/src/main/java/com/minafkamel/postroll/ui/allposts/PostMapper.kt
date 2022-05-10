package com.minafkamel.postroll.ui.allposts

class PostMapper {

    operator fun invoke(id: String, title: String, body: String) =
        PostViewEntity(id, title, """${body.take(BODY_MAX_LENGTH)}...""")

    class PostViewEntity(val id: String, val title: String, val body: String)

    companion object {
        const val BODY_MAX_LENGTH = 120
    }
}
