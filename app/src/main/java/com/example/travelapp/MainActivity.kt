package com.example.travelapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelapp.components.PlaceCard
import com.example.travelapp.layouts.AppLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLayout {
                TravelApp(context = this)
            }
        }
    }
}

@Composable
fun TravelApp(context: Context) {

    Column(
        modifier = Modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        PlaceCard(
            image = R.drawable.bali_cover,
            place = R.string.place_1,
            placeDesc = R.string.description,
            plan = R.string.plan,
            context = context,
            Class=BaliActivity::class.java
        )
        PlaceCard(
            image = R.drawable.paris_cover,
            place = R.string.place_2,
            placeDesc = R.string.description,
            plan = R.string.plan,
            context = context,
            Class=ParisActivity::class.java

        )
        PlaceCard(
            image = R.drawable.singapore_cover,
            place = R.string.place_3,
            placeDesc = R.string.description,
            plan = R.string.plan,
            context = context,
            Class=SingaporeActivity::class.java

        )
    }

}

