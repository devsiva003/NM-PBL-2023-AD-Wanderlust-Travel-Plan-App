package com.example.travelapp.components

import android.content.Context
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun <T> PlaceCard(
    @DrawableRes image: Int,
    @StringRes place: Int,
    @StringRes placeDesc: Int,
    @StringRes plan: Int, context: Context,
    Class: Class<T>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(0.dp, 10.dp)
            .clip(RoundedCornerShape(3.dp))
            .clickable {
                context.startActivity(
                    Intent(context, Class)

                )
            },
        elevation = 50.dp,

        ) {
        Column {
            Image(
                painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = place),
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = MaterialTheme.typography.h5.fontFamily,
                fontWeight = MaterialTheme.typography.h5.fontWeight,

                )


            Text(
                text = stringResource(id = placeDesc),
                style = MaterialTheme.typography.body1,
            )

            Text(
                text = stringResource(id = plan),
                style = MaterialTheme.typography.body1,
            )
        }
    }
}