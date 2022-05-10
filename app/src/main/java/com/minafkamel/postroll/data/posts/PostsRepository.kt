package com.minafkamel.postroll.data.posts

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.models.GetPostDetailsQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PostsRepository(
    private val remoteDataSource: PostsRemoteDataSource,
    private val memoryDataSource: PostsMemoryDataSource
) {

    fun getAllPosts(forceFetch: Boolean = true): Flow<GetAllPostsQuery.Data> {
        return if (forceFetch) {
            remoteDataSource.fetchAllPosts()
                .map { it.dataAssertNoErrors }
                .also { it.map { memoryDataSource.writePosts(it) } }
                .catch { /** Log error **/ }
        } else {
            memoryDataSource.readPosts()
                .map { it!! }
        }
    }

    fun getPostDetails(id: String): Flow<GetPostDetailsQuery.Data> {
        return remoteDataSource.fetchPostDetails(id)
            .map { it.dataAssertNoErrors }
    }
}
