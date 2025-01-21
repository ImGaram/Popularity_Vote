package com.assignment.popularityvote.feature.main.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.popularityvote.common.compose.PopularityVoteText

@Composable
fun TimeBox(
    value: String = "0",
    unit: String = ""
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF242122)
            )
        ) {
            PopularityVoteText(
                text = value,
                modifier = Modifier.padding(12.dp),
                style = TextStyle(
                    color = Color(0xFFDADADA),
                    fontWeight = FontWeight.W500,
                    fontSize = 22.sp
                )
            )
        }

        PopularityVoteText(
            text = unit,
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                color = Color(0xFFDADADA),
                fontWeight = FontWeight.W500,
                fontSize = 10.sp
            )
        )
    }
}

@Preview
@Composable
private fun TimeBoxPreview() {
    TimeBox(
        value = "23",
        unit = "DAY"
    )
}