package com.example.travelapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.components.PlaceCard
import com.example.travelapp.navigation.Routes

@Composable
fun HomeScreen(goToPlace: (place: String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        PlaceCard(
            image = R.drawable.bali_cover,
            place = R.string.place_1,
            price = "$999",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Bali.name) }
        )

        PlaceCard(
            image = R.drawable.paris_cover,
            place = R.string.place_2,
            price = "$1299",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Paris.name) }
        )

        PlaceCard(
            image = R.drawable.singapore_cover,
            place = R.string.place_3,
            price = "$888",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Singapore.name) }
        )
    }
}