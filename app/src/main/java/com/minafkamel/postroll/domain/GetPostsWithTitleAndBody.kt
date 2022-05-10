package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.PostsRepository
import com.minafkamel.postroll.domain.GetPostsWithTitleAndBody.Post
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetPostsWithTitleAndBody(
    private val postsRepository: PostsRepository
) : UseCase<NoParams, List<Post>> {

    override suspend fun invoke(params: NoParams): Flow<List<Post>> {
        return postsRepository.getAllPosts()
            .map { item -> item.posts?.data!!}
            .map { posts -> posts.map { getPostById(it?.id!!) } }
    }

    private suspend fun getPostById(id: String): Post  {
        return postsRepository.getPost(id)
            .map { Post(it.post?.title!!, it.post.body!!) }
            .first()
    }

    data class Post(val title: String, val body: String)
}
