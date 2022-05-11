package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class GetPostDetails(
    private val repository: PostsRepository
) : UseCase<GetPostDetails.Params, GetPostDetails.Details> {

    override suspend fun invoke(params: Params): Flow<Details> {
        val allPostsFlow = repository.getAllPosts(true)
            .map { findPostById(it, params.id) }

        val detailsFlow = repository.getPostDetails(params.id)
            .map { it.post!!.user }

        return allPostsFlow.combine(detailsFlow) { post, details ->
            Details(post?.title!!, post.body!!, details?.name!!, details.username!!)
        }
    }

    private fun findPostById(it: GetAllPostsQuery.Data, id: String): GetAllPostsQuery.Data1? {
        return it.posts!!.data?.first { it?.id == id }
    }

    class Params(val id: String)
    class Details(val title: String, val body: String, val name: String, val username: String)
}
