package com.minafkamel.postroll.ui.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minafkamel.postroll.ui.LoadingView
import com.minafkamel.postroll.util.UiState
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsScreen() {
    val viewModel = getViewModel<DetailsViewModel>()
    val details = viewModel.details


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (details) {
            is UiState.Success -> {
                DetailsView(
                    post = details.data,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            is UiState.Loading -> {
                LoadingView()
            }
        }
    }
}