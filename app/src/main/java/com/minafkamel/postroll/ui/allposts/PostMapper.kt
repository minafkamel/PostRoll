package com.minafkamel.postroll.ui.allposts

class PostMapper {

    fun map(title: String, body: String) =
        PostViewEntity(title, """${body.take(BODY_MAX_LENGTH)}...""")

    class PostViewEntity(val title: String, val body: String)

    companion object {
        const val BODY_MAX_LENGTH = 120
    }
}
