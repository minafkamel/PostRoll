package com.minafkamel.postroll.data.posts

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PostsRepository(private val remoteDataSource: PostsRemoteDataSource) {

    fun getAllPosts(): Flow<GetAllPostsQuery.Data> {
        return remoteDataSource.fetchAllPosts()
            .map { it.dataAssertNoErrors }
            .catch { /** NO-OP**/ }
    }
}
