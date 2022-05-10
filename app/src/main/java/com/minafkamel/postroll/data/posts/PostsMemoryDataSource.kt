package com.minafkamel.postroll.data.posts

import com.minafkamel.postroll.data.Cache
import com.minafkamel.postroll.data.models.GetAllPostsQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PostsMemoryDataSource(private val cache: Cache) {

    fun writePosts(posts: GetAllPostsQuery.Data): Flow<Unit> {
        return flowOf(cache.put(KEY_POSTS, posts))
    }

    fun readPosts(): Flow<GetAllPostsQuery.Data?> {
        return flowOf(cache.getItem<GetAllPostsQuery.Data>(KEY_POSTS))
    }

    companion object {
        const val KEY_POSTS = "KEY_POSTS"
    }
}
