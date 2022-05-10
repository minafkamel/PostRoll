package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.domain.GetPostsWithTitleAndBody.Post
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPostsWithTitleAndBody(
    private val postsRepository: PostsRepository
) : UseCase<NoParams, List<Post>> {

    override suspend fun invoke(params: NoParams): Flow<List<Post>> {
        return postsRepository.getAllPosts()
            .map { item -> item.posts?.data!! }
            .map { it.map { Post(it?.title!!, it?.body!!) } }
    }

    data class Post(val title: String, val body: String)
}
