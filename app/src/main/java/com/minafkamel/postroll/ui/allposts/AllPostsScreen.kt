package com.minafkamel.postroll.ui.allposts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.minafkamel.postroll.R
import com.minafkamel.postroll.navigation.NavRoutes
import com.minafkamel.postroll.ui.LoadingView
import com.minafkamel.postroll.ui.allposts.PostMapper.PostViewEntity
import com.minafkamel.postroll.ui.common.TopBar
import com.minafkamel.postroll.util.UiState
import org.koin.androidx.compose.getViewModel

const val POSTS_TEST_TAG = "POSTS_TEST_TAG"

@Composable
fun AllPostsScreen(navController: NavHostController) {
    val viewModel = getViewModel<AllPostsViewModel>()
    val posts = viewModel.allPosts

    Scaffold(topBar = {
        TopBar(stringResource(id = R.string.posts_title))
    }) {
        PostsBody(posts, navController)
    }
}

@Composable
fun PostsBody(posts: UiState<List<PostViewEntity>>, navController: NavHostController) {
    val scrollState = rememberLazyListState()

    when (posts) {
        is UiState.Success -> {
            LazyColumn(state = scrollState, modifier = Modifier.testTag(POSTS_TEST_TAG)) {
                item {
                    posts.data.forEach {
                        PostView(
                            title = it.title,
                            body = it.body,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            openDetails(navController, it.id)
                        }
                    }
                }
            }
        }
        is UiState.Loading -> {
            LoadingView()
        }
    }
}

fun openDetails(navController: NavHostController, postId: String) {
    navController.navigate(NavRoutes.Details.create(postId))
}
