package com.example.travelapp.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.travelapp.R
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun AppLayout(Content: @Composable () -> Unit) {
    TravelAppTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary, title = {
                Text(
                    stringResource(
                        id = R.string.app_title
                    ),
                    fontFamily = MaterialTheme.typography.h1.fontFamily,
                    fontWeight = MaterialTheme.typography.h1.fontWeight
                )
            })
        }) { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                color = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface
            ) { Content() }
        }
    }
}