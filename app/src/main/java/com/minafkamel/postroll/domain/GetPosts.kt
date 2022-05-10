package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.domain.GetPosts.Post
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPosts(
    private val postsRepository: PostsRepository
) : UseCase<NoParams, List<Post>> {

    override suspend fun invoke(params: NoParams): Flow<List<Post>> {
        return postsRepository.getAllPosts()
            .map { item -> item.posts?.data!! }
            .map {
                it.map {
                    val data = checkNotNull(it)
                    val id = checkNotNull(data.id)
                    val title = checkNotNull(data.title)
                    val body = checkNotNull(data.body)
                    Post(id, title, body)
                }
            }
    }

    data class Post(val id: String, val title: String, val body: String)
}
