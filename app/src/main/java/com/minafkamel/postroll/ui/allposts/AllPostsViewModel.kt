package com.minafkamel.postroll.ui.allposts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minafkamel.postroll.domain.GetPostsWithTitleAndBody
import com.minafkamel.postroll.domain.base.NoParams
import com.minafkamel.postroll.util.UiState
import kotlinx.coroutines.launch

class AllPostsViewModel(private val getPostsWithTitleAndBody: GetPostsWithTitleAndBody) :
    ViewModel() {

    var allPosts by mutableStateOf<UiState<List<GetPostsWithTitleAndBody.Post>>>(UiState.Loading)
        private set

    init {
        viewModelScope.launch {
            allPosts = UiState.Loading
            getPostsWithTitleAndBody(NoParams)
                .collect {
                    allPosts = UiState.Success(it)
                }
        }
    }
}
