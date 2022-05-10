package com.minafkamel.postroll.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.minafkamel.postroll.domain.GetPostDetails

@Composable
fun DetailsView(
    post: GetPostDetails.Post,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.background)
    ) {

        Text(
            post.title,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            post.body,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            post.name,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            post.username,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(8.dp)
        )
    }
}
