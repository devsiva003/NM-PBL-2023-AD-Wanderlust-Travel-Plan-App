package com.example.travelapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlanItem(caption: String, activities: List<String>) {
    Text(style = MaterialTheme.typography.h6, text = caption.uppercase())

    Spacer(modifier = Modifier.padding(2.dp))

    Text(
        text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textIndent = TextIndent(25.sp))) {
                append(activities.joinToString(separator = "\n"))
            }
        },
    )
}