package com.assignment.popularityvote.common.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.popularityvote.ui.theme.Primary

@Composable
fun PopularityVoteButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
    text: String = "text",
    textStyle: TextStyle = LocalTextStyle.current,
    buttonIcon: @Composable () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = colors,
        border = border
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            buttonIcon()

            PopularityVoteText(
                text = text,
                modifier = Modifier.padding(start = 4.dp),
                style = textStyle
            )
        }
    }
}

@Preview
@Composable
private fun PopularityVoteButtonPreview() {
    Column {
        PopularityVoteButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(width = 1.dp, color = Primary),
            text = "test",
            textStyle = TextStyle(
                color = Primary
            ),
            buttonIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "vote",
                    tint = Primary
                )
            }
        )
    }
}