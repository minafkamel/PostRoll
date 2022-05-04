package com.minafkamel.postroll.data

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.error.Failure
import com.minafkamel.postroll.util.Either
import com.minafkamel.postroll.util.left
import com.minafkamel.postroll.util.right
import java.lang.Exception

class PostsRepository(private val remoteDataSource: PostsRemoteDataSource) {

    suspend fun getAllPosts(): Either<Failure, GetAllPostsQuery.Data> {
        return try {
            val result = remoteDataSource.fetchAllPosts()
            right(result.dataAssertNoErrors)
        } catch (e: Exception) {
            left(Failure.UnexpectedFailure)
        }
    }
}
