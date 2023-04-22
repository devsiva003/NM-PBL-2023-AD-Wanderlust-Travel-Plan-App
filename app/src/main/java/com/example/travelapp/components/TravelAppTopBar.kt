package com.example.travelapp.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.travelapp.R

@Composable
fun TravelAppTopBar(logout: () -> Unit) {
    TopAppBar(backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        title = {
            Text(
                stringResource(
                    id = R.string.app_title
                ),
                fontFamily = MaterialTheme.typography.h1.fontFamily,
                fontWeight = MaterialTheme.typography.h1.fontWeight
            )
        },
        actions = {
            IconButton(onClick = { logout() }) {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = "Logout",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        })

}