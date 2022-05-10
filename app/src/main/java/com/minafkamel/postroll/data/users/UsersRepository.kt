package com.minafkamel.postroll.data.users

import com.minafkamel.postroll.data.models.GetAllPostsQuery
import com.minafkamel.postroll.data.models.GetAllUsersQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UsersRepository(private val remoteDataSource: UsersRemoteDataSource) {

    fun getUsers(): Flow<GetAllUsersQuery.Data> {
        return remoteDataSource.getAllUsers()
            .map { it.dataAssertNoErrors }
            .catch { /** NO-OP**/ }
    }
}
