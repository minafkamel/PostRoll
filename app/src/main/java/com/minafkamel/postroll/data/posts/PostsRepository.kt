package com.minafkamel.postroll.data.posts

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.models.GetPostQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PostsRepository(private val remoteDataSource: PostsRemoteDataSource) {

    fun getAllPosts(): Flow<GetAllPostsQuery.Data> {
        return remoteDataSource.fetchAllPosts()
            .map { it.dataAssertNoErrors }
            .catch { /** NO-OP**/ }
    }

    fun getPost(id: String): Flow<GetPostQuery.Data> {
        return remoteDataSource.fetchPost(id)
            .map { it.dataAssertNoErrors }
            .catch { /** NO-OP**/ }
    }
}
