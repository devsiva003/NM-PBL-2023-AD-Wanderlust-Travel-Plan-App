package com.example.travelapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

@Composable
fun ParisScreen() {
    PlaceView(placeName = R.string.place_2, placeImage = R.drawable.paris_cover) {
        ParisPlans()
    }

}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "Day 1: Arrival and Introduction",
        "activities" to listOf(
            "Check into your accommodation and freshen up",
            "Take a stroll around the neighborhood to get acquainted",
            "Visit the Eiffel Tower, preferably in the evening when it is lit up",
            "Have a relaxing dinner at a nearby restaurant"
        )
    ),
    mapOf(
        "caption" to "Day 2: Art and History",
        "activities" to listOf(
            "Visit the Louvre Museum to see some of the world's most famous art pieces",
            "Stroll through the Tuileries Garden and the Place de la Concorde",
            "Visit the Orsay Museum, which houses a large collection of impressionist art",
            "Have dinner at a local French restaurant"
        )
    ),
    mapOf(
        "caption" to "Day 3: French Culture and Food",
        "activities" to listOf(
            "Visit the Montmartre neighborhood to see the famous Basilique du Sacré-Cœur and Place du Tertre",
            "Explore the historic neighborhood of Le Marais",
            "Try some delicious French pastries at a local bakery",
            "Have dinner at a brasserie to taste some classic French cuisine"
        )
    ),
    mapOf(
        "caption" to "Day 4: Architecture and Gardens",
        "activities" to listOf(
            "Visit the Palace of Versailles, a UNESCO World Heritage site, and explore its beautiful gardens",
            "Walk along the Champs-Elysées and stop at the Arc de Triomphe",
            "Visit the Sainte-Chapelle, a beautiful Gothic chapel with stunning stained-glass windows",
            "Have dinner at a local restaurant in the 7th arrondissement"
        )
    ),
    mapOf(
        "caption" to "Day 5: Shopping and Sightseeing",
        "activities" to listOf(
            "Visit the Notre-Dame Cathedral and climb up to the top for a stunning view of the city",
            "Explore the Latin Quarter and visit the Panthéon",
            "Go shopping at the famous Galeries Lafayette or Printemps department stores",
            "Have dinner at a local bistro"
        )
    ),
    mapOf(
        "caption" to "Day 6: Parisian Parks and Museums",
        "activities" to listOf(
            "Visit the Musée Rodin and explore its beautiful gardens",
            "Stroll through the Luxembourg Gardens and visit the Luxembourg Palace",
            "Visit the Centre Pompidou, a modern art museum in the Marais neighborhood",
            "Have dinner at a local restaurant in the Latin Quarter"
        )
    ),
    mapOf(
        "caption" to "Day 7: River Cruise and Farewell",
        "activities" to listOf(
            "Take a boat cruise along the Seine River to see the city from a different perspective",
            "Visit the Musée de l'Orangerie, which houses Monet's famous water lilies paintings",
            "Have a farewell dinner at a Michelin-starred restaurant"
        )
    )
)


@Composable
private fun ParisPlans() {
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
fun ParisPlansPreview() {
    PlaceView(placeName = R.string.place_2, placeImage = R.drawable.paris_cover) {
        ParisPlans()
    }
}
