package com.assignment.popularityvote.common.compose

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.assignment.popularityvote.common.font.Kantumruy

@Composable
fun PopularityVoteText(
    text: String = "text",
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = Kantumruy,
        style = style
    )
}