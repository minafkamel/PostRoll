package com.minafkamel.postroll.domain

import com.minafkamel.postroll.data.posts.PostsRepository
import com.minafkamel.postroll.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPostDetails(
    private val repository: PostsRepository
) : UseCase<GetPostDetails.Params, GetPostDetails.Details> {

    override suspend fun invoke(params: Params): Flow<Details> {
        return repository.getAllPosts()
            .map { item -> item.posts?.data!! }
            .map { it.find { it?.id == params.id } }
            .map {
                val data = checkNotNull(it)
                val title = checkNotNull(data.title)
                val body = checkNotNull(data.body)
                val user =  checkNotNull(data.user)
                val name = checkNotNull(user.name)
                val username = checkNotNull(user.username)
                Details(title, body, name, username)
            }
    }

    class Params(val id: String)
    class Details(val title: String, val body: String, val name: String, val username: String)
}
