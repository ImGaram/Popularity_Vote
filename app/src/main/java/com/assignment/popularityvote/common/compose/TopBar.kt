package com.assignment.popularityvote.common.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String = "2024 WMU",
    backArrowEnable: Boolean = false,
    exitEnable: Boolean = false,
    onBackArrowClick: () -> Unit = {},
    onExitClick: () -> Unit = {},
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onBackArrowClick,
            modifier = Modifier.padding(start = 16.dp),
            enabled = backArrowEnable
        ) {
            if (backArrowEnable) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back arrow"
                )
            }
        }

        PopularityVoteText(
            text = title,
            modifier = Modifier.padding(vertical = 16.dp),
            style = TextStyle(
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            )
        )

        IconButton(
            onClick = onExitClick,
            modifier = Modifier.padding(end = 16.dp),
            enabled = exitEnable
        ) {
            if (exitEnable) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "exit"
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(
        modifier = Modifier.fillMaxWidth(),
        backArrowEnable = true,
        onBackArrowClick = {},
        onExitClick = {}
    )
}