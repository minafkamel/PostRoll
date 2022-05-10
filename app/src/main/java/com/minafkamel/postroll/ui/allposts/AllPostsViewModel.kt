package com.minafkamel.postroll.ui.allposts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minafkamel.postroll.domain.GetPosts
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.ui.allposts.PostMapper.PostViewEntity
import com.minafkamel.postroll.util.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AllPostsViewModel(
    private val getPosts: GetPosts,
    private val mapper: PostMapper
) : ViewModel() {

    var allPosts by mutableStateOf<UiState<List<PostViewEntity>>>(UiState.Loading)
        private set

    init {
        viewModelScope.launch {
            allPosts = UiState.Loading
            getPosts(NoParams)
                .map { mapToViewEntity(it) }
                .collect {
                    allPosts = UiState.Success(it)
                }
        }
    }

    private fun mapToViewEntity(it: List<GetPosts.Post>) =
        it.map { mapper(it.id, it.title, it.body) }
}
