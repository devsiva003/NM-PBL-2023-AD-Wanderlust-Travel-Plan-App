package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

class SingaporeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaceView(placeName = R.string.place_3, placeImage = R.drawable.singapore_cover) {
                SingaporePlans()
            }
        }
    }
}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "Day 1:",
        "activities" to listOf(
            "Visit Gardens by the Bay and marvel at the Supertree Grove and the Flower Dome and Cloud Forest conservatories.",
            "Explore the Marina Bay Sands complex, which includes a casino, luxury shopping mall, and observation deck with a stunning view of the city."
        )
    ),
    mapOf(
        "caption" to "Day 2:",
        "activities" to listOf(
            "Explore the historic district of Chinatown, including the Buddha Tooth Relic Temple and Museum and the Sri Mariamman Temple.",
            "Visit the nearby Clarke Quay for lunch and to explore its waterfront restaurants, bars, and shops."
        )
    ),
    mapOf(
        "caption" to "Day 3:",
        "activities" to listOf(
            "Take a tour of the UNESCO-listed Botanic Gardens, one of the world's most famous and significant tropical gardens.",
            "Head over to the National Museum of Singapore, which houses a vast collection of historical and cultural artifacts."
        )
    ),
    mapOf(
        "caption" to "Day 4:",
        "activities" to listOf(
            "Visit the Singapore Zoo and admire the wildlife, including orangutans, tigers, and elephants.",
            "Head over to Sentosa Island and relax at one of its many beaches or try some of the many attractions such as Universal Studios Singapore or Adventure Cove Waterpark."
        )
    ),
    mapOf(
        "caption" to "Day 5:",
        "activities" to listOf(
            "Go on a nature walk at MacRitchie Reservoir, which offers hiking trails and stunning views of the city skyline.",
            "Visit Little India, a vibrant and colorful neighborhood, and explore the shops, temples, and food stalls."
        )
    ),
    mapOf(
        "caption" to "Day 6:",
        "activities" to listOf(
            "Explore the trendy neighborhood of Tiong Bahru, known for its hip cafes and boutiques, as well as its Art Deco architecture.",
            "Visit the National Gallery Singapore, which houses the largest public collection of modern art in Singapore and Southeast Asia."
        )
    ),
    mapOf(
        "caption" to "Day 7:",
        "activities" to listOf(
            "Take a day trip to the nearby island of Pulau Ubin, where you can rent a bike and explore the island's traditional kampong villages and nature trails."
        )
    )
)


@Composable
private fun SingaporePlans() {
    PLANS_DATA.forEach { plan ->
        PlanItem(
            caption = plan["caption"] as String,
            activities = plan["activities"] as List<String>
        )
    }
}

@Preview
@Composable
fun SingaporePlansPreview() {
    PlaceView(placeName = R.string.place_3, placeImage = R.drawable.singapore_cover) {
        SingaporePlans()
    }
}