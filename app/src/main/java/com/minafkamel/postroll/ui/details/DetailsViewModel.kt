package com.minafkamel.postroll.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minafkamel.postroll.domain.GetPostDetails
import com.minafkamel.postroll.util.UiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailsViewModel(private val getPostDetails: GetPostDetails, postId: String) : ViewModel() {
    var details by mutableStateOf<UiState<GetPostDetails.Details>>(UiState.Loading)
        private set

    init {
        viewModelScope.launch {
            details = UiState.Loading
            getPostDetails(GetPostDetails.Params(postId))
                .catch { details = UiState.Error }
                .collect {
                    details = UiState.Success(it)
                }
        }
    }
}
