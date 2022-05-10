package com.minafkamel.postroll.data.users

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.minafkamel.postroll.data.models.GetAllUsersQuery
import kotlinx.coroutines.flow.Flow

class UsersApi(private val apolloClient: ApolloClient) {

    fun getAllUsers(): Flow<ApolloResponse<GetAllUsersQuery.Data>> {
        return apolloClient.query(GetAllUsersQuery()).toFlow()
    }
}
