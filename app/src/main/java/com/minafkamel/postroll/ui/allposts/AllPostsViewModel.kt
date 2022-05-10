package com.minafkamel.postroll.ui.allposts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minafkamel.postroll.domain.GetPostsWithTitleAndBody
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.ui.allposts.PostMapper.PostViewEntity
import com.minafkamel.postroll.util.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AllPostsViewModel(
    private val getPostsWithTitleAndBody: GetPostsWithTitleAndBody,
    private val mapper: PostMapper
) :
    ViewModel() {

    var allPosts by mutableStateOf<UiState<List<PostViewEntity>>>(UiState.Loading)
        private set

    init {
        viewModelScope.launch {
            allPosts = UiState.Loading
            getPostsWithTitleAndBody(NoParams)
                .map { mapToViewEntity(it) }
                .collect {
                    allPosts = UiState.Success(it)
                }
        }
    }

    private fun mapToViewEntity(it: List<GetPostsWithTitleAndBody.Post>) =
        it.map { mapper.map(it.title, it.body) }
}
