package com.minafkamel.postroll.ui.allposts

class PostMapper {

    fun map(title: String, body: String) = PostViewEntity(title, """${body.substring(0, 120)}...""")

    class PostViewEntity(val title: String, val body: String)
}
