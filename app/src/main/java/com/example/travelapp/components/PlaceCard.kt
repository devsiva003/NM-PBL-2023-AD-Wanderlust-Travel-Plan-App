package com.example.travelapp.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun PlaceCard(
    @DrawableRes image: Int,
    @StringRes place: Int,
    price: String,
    plan: String,
    noOfDays: Int,
    noOfPersons: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(0.dp, 10.dp)
            .clip(RoundedCornerShape(3.dp))
            .clickable {
                onClick()
            },
        elevation = 50.dp,

        ) {
        Column {
            Box {
                Image(
                    painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = plan.uppercase(),
                    modifier = Modifier
                        .background(MaterialTheme.colors.secondary)
                        .padding(2.dp, 0.dp)
                        .align(Alignment.TopEnd),
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 8.sp,

                    )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
            ) {
                Column {
                    Text(
                        text = stringResource(id = place),
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontFamily = MaterialTheme.typography.h5.fontFamily,
                        fontWeight = MaterialTheme.typography.h5.fontWeight,

                        )
                    Row {
                        Row(
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary.copy(.75f))
                                .padding(2.dp, 0.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = "Schedule",
                                modifier = Modifier.size(MaterialTheme.typography.body2.fontSize.value.dp),
                                tint = MaterialTheme.colors.onSecondary
                            )
                            Text(
                                text = "$noOfDays Days",
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSecondary
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary.copy(.75f))
                                .padding(2.dp, 0.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Group,
                                contentDescription = "People",
                                modifier = Modifier.size(MaterialTheme.typography.body2.fontSize.value.dp),
                                tint = MaterialTheme.colors.onSecondary
                            )
                            Text(
                                text = "$noOfPersons Persons",
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSecondary
                            )
                        }
                    }
                }
                Text(
                    text = price,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 5.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    TravelAppTheme {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            PlaceCard(
                image = R.drawable.bali_cover,
                place = R.string.place_1,
                plan = "Super Saver",
                price = "$999",
                noOfPersons = 2,
                noOfDays = 7,
                onClick = {}
            )
        }
    }
}