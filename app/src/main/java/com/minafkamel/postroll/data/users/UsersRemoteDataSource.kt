package com.minafkamel.postroll.data.users

class UsersRemoteDataSource(private val postApi: UsersApi) {

    fun getAllUsers() = postApi.getAllUsers()
}
