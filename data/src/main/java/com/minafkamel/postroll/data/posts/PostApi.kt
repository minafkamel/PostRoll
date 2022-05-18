package com.minafkamel.postroll.data.posts

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.minafkamel.postroll.data.models.GetAllPostsQuery
import kotlinx.coroutines.flow.Flow

class PostApi(private val apolloClient: ApolloClient) {

    fun getAllPosts(): Flow<ApolloResponse<GetAllPostsQuery.Data>> {
        return apolloClient.query(GetAllPostsQuery()).toFlow()
    }
}
