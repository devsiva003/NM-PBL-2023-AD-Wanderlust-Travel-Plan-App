package com.example.travelapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

@Composable
fun BaliScreen() {
    PlaceView(placeName = R.string.place_1, placeImage = R.drawable.bali_cover) {
        BaliPlans()
    }
}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "Day 1: Arrival and Relaxation",
        "activities" to listOf(
            "Arrive in Bali and check into your hotel or accommodation.",
            "Spend the day relaxing and getting acclimated to the island.",
            "If you have time, explore the nearby area or head to the beach."
        )
    ),
    mapOf(
        "caption" to "Day 2: Ubud Tour",
        "activities" to listOf(
            "Start your day early and head to Ubud, a cultural and artistic hub in Bali.",
            "Visit the Monkey Forest and the Ubud Palace.",
            "Take a tour of the Tegalalang Rice Terrace, a beautiful UNESCO World Heritage Site.",
            "End your day with a traditional Balinese dance performance."
        )
    ),
    mapOf(
        "caption" to "Day 3: Temple Hopping",
        "activities" to listOf(
            "Visit some of Bali's most famous temples, such as Tanah Lot and Uluwatu.",
            "Take in the stunning views of the ocean and cliffs.",
            "Enjoy a sunset dinner at one of the many restaurants near the temples."
        )
    ),
    mapOf(
        "caption" to "Day 4: Waterfalls and Beaches",
        "activities" to listOf(
            "Take a day trip to Bali's beautiful waterfalls, such as Tegenungan or Gitgit.",
            "Spend the afternoon at one of Bali's world-renowned beaches, like Seminyak or Nusa Dua."
        )
    ),
    mapOf(
        "caption" to "Day 5: Island Hopping",
        "activities" to listOf(
            "Take a day trip to one of Bali's neighboring islands, such as Nusa Lembongan or Gili Islands.",
            "Snorkel or scuba dive in the clear waters and relax on the beach."
        )
    ),
    mapOf(
        "caption" to "Day 6: Cultural Activities",
        "activities" to listOf(
            "Visit a traditional Balinese village and learn about the island."
        )
    ),
    mapOf(
        "caption" to "Day 7: Departure",
        "activities" to listOf(
            "Explore the surrounding area and take in the stunning sunset views.",
            "Have dinner at a local restaurant before returning to your accommodation."
        )
    )
)

@Composable
private fun BaliPlans() {
    PLANS_DATA.forEach { plan ->
        @Suppress("UNCHECKED_CAST")
        PlanItem(
            caption = plan["caption"] as String,
            activities = plan["activities"] as List<String>
        )
    }

}
@Preview
@Composable
fun BaliPlansPreview() {
    PlaceView(placeName = R.string.place_1, placeImage = R.drawable.bali_cover) {
        BaliPlans()
    }
}