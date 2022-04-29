package com.minafkamel.postroll.data.models

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse

class PostApi(private val apolloClient: ApolloClient) {

    suspend fun getAllPosts(): ApolloResponse<GetAllPostsQuery.Data> {
        return apolloClient.query(GetAllPostsQuery()).execute()
    }

    suspend fun getPost(id: String): ApolloResponse<GetPostQuery.Data> {
        return apolloClient.query(GetPostQuery(id)).execute()
    }
}
