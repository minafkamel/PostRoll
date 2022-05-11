package com.minafkamel.postroll.ui.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.minafkamel.postroll.R
import com.minafkamel.postroll.domain.GetPostDetails
import com.minafkamel.postroll.ui.LoadingView
import com.minafkamel.postroll.ui.common.TopBar
import com.minafkamel.postroll.util.UiState
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsScreen() {
    val viewModel = getViewModel<DetailsViewModel>()
    val details = viewModel.details

    Scaffold(topBar = {
        TopBar(stringResource(id = R.string.details_title))
    }
    ) {
        DetailsBody(details)
    }
}

@Composable
fun DetailsBody(details: UiState<GetPostDetails.Details>) {
    when (details) {
        is UiState.Success -> {
            DetailsView(
                details = details.data,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        is UiState.Loading -> {
            LoadingView()
        }
    }
}
