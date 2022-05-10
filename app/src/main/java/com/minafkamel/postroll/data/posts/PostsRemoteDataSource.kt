package com.minafkamel.postroll.data.posts

class PostsRemoteDataSource(private val postApi: PostApi) {

    fun fetchAllPosts() = postApi.getAllPosts()

    fun fetchPostDetails(id: String) = postApi.getPostDetails(id)
}
