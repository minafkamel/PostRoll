package com.minafkamel.postroll.ui.allposts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.minafkamel.postroll.R

@Composable
fun PostView(
    title: String,
    body: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.background)
            .clickable(onClick = onClick),
    ) {

        Title(title)
        Body(body)
    }
}

@Composable
fun Title(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(
            dimensionResource(id = R.dimen.screen_padding),
            dimensionResource(id = R.dimen.posts_title_top_padding),
            dimensionResource(id = R.dimen.screen_padding),
            dimensionResource(id = R.dimen.posts_title_bottom_padding)
        )
    )
}

@Composable
fun Body(body: String) {
    Text(
        body,
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(
            dimensionResource(id = R.dimen.screen_padding),
            dimensionResource(id = R.dimen.posts_body_top_padding),
            dimensionResource(id = R.dimen.screen_padding),
            dimensionResource(id = R.dimen.posts_body_bottom_padding)
        ),
        color = Color.Gray
    )
}
