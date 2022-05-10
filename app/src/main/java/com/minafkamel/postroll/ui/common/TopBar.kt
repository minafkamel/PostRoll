package com.minafkamel.postroll.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title: String) {
    TopAppBar {
        Text(
            title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(8.dp)
        )
    }
}
