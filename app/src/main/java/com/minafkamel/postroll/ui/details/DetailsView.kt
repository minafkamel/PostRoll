package com.minafkamel.postroll.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.minafkamel.postroll.R
import com.minafkamel.postroll.domain.GetPostDetails

@Composable
fun DetailsView(
    details: GetPostDetails.Details,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.background)
            .padding(dimensionResource(id = R.dimen.screen_padding))
    ) {

        Text(
            details.title,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Light
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                details.name,
                style = MaterialTheme.typography.body2,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                details.username,
                style = MaterialTheme.typography.body2,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(8.dp)
            )
        }


        Text(
            details.body,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Medium
        )


    }
}
