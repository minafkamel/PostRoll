package com.minafkamel.postroll.ui.allposts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minafkamel.postroll.ui.LoadingView
import com.minafkamel.postroll.util.UiState
import org.koin.androidx.compose.getViewModel


@Composable
fun AllPostsScreen() {
    val viewModel = getViewModel<AllPostsViewModel>()
    val scrollState = rememberLazyListState()
    val posts = viewModel.allPosts

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(state = scrollState) {

            when (posts) {
                is UiState.Success -> {
                    item {
                        posts.data.forEach {
                            PostView(
                                title = it.title,
                                body = it.body,
                                modifier = Modifier.padding(bottom = 16.dp)
                            ) {

                            }
                        }

                    }
                }
                is UiState.Loading -> {
                    item {
                        LoadingView()
                    }
                }
            }
        }
    }
}