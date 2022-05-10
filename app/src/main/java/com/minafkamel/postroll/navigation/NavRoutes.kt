package com.minafkamel.postroll.navigation

sealed class NavRoutes(val route: String) {
    object AllPosts : NavRoutes("allposts")
    object Details : NavRoutes("details/{postId}") {
        fun create(postId: String) = "details/$postId"
    }
}
