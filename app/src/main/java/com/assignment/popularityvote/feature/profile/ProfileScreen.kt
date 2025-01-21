package com.assignment.popularityvote.feature.profile

import androidx.compose.runtime.Composable
import com.assignment.popularityvote.common.compose.PopularityVoteText
import com.assignment.popularityvote.common.navigation.Screen

@Composable
fun ProfileScreen(
    navigateToMain: () -> Unit,
    args: Screen.ProfileScreen
) {
    PopularityVoteText(
        text = args.id.toString()
    )
}
