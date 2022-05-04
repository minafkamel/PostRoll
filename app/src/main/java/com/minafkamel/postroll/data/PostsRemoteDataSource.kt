package com.minafkamel.postroll.data

import com.minafkamel.postroll.data.models.PostApi

class PostsRemoteDataSource(private val postApi: PostApi) {

    suspend fun fetchAllPosts() = postApi.getAllPosts()
}
