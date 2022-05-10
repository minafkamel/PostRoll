package com.minafkamel.postroll.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.models.GetPostQuery
import com.minafkamel.postroll.data.models.type.PageQueryOptions
import com.minafkamel.postroll.data.models.type.PaginateOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.retry

class PostApi(private val apolloClient: ApolloClient) {

    fun getAllPosts(): Flow<ApolloResponse<GetAllPostsQuery.Data>> {
        return apolloClient.query(
            GetAllPostsQuery(
                Optional.presentIfNotNull(
                    PageQueryOptions(
                        paginate = Optional.presentIfNotNull(
                            PaginateOptions(
                                Optional.presentIfNotNull(
                                    1
                                ), Optional.presentIfNotNull(5)
                            )
                        )
                    )
                )
            )
        ).toFlow()
    }

    fun getPost(id: String): Flow<ApolloResponse<GetPostQuery.Data>> {
        return apolloClient.query(GetPostQuery(id)).toFlow()
    }
}
