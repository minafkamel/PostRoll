package com.minafkamel.postroll.data

class PostsRemoteDataSource(private val postApi: PostApi) {

    fun fetchAllPosts() = postApi.getAllPosts()

    fun fetchPost(id: String) = postApi.getPost(id)
}
