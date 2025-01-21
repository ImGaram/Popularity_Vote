package com.assignment.popularityvote.feature.main.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.popularityvote.common.compose.PopularityVoteText
import com.assignment.popularityvote.ui.theme.BackgroundLight
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White

@Composable
fun VoteInfoColumn() {
    Column(
        Modifier.padding(horizontal = 16.dp, vertical = 50.dp)
    ) {
        PopularityVoteText(
            text = "WORLD MISS UNIVERSITY",
            style = TextStyle(
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
            )
        )

        PopularityVoteText(
            text = "Mobile Voting\nInformation",
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                color = White,
                fontWeight = FontWeight.W600,
                fontSize = 28.sp
            )
        )

        PopularityVoteText(
            text = "2024 World Miss University brings\ntogether future global leaders who embody both\nbeauty and intellect.",
            modifier = Modifier.padding(top = 40.dp),
            style = TextStyle(
                color = Color(0xFFAEAEB2),
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            colors = CardDefaults.cardColors(containerColor = BackgroundLight),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row() {
                    PopularityVoteText(
                        text = "Period",
                        style = TextStyle(
                            color = Color(0xFFDBDBDB),
                            fontWeight = FontWeight.W500,
                            fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    PopularityVoteText(
                        text = "10/17(Thu) 12PM - 10/31(Thu) 6PM",
                        style = TextStyle(
                            color = Color(0xFFDBDBDB),
                            fontWeight = FontWeight.W400,
                            fontSize = 13.sp
                        )
                    )
                }

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 14.dp),
                    color = Color(0xFF282627)
                )

                Row() {
                    PopularityVoteText(
                        text = "How to vote",
                        style = TextStyle(
                            color = Color(0xFFDBDBDB),
                            fontWeight = FontWeight.W500,
                            fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    PopularityVoteText(
                        text = " • Up to three people\n" +
                                "can participate in early voting per\n" +
                                "day. \n\n" +
                                " • Three new voting tickets are\n" +
                                "issued every day at midnight\n" +
                                "(00:00), and you can vote anew\n" +
                                "every day during the early voting\n" +
                                "period",
                        style = TextStyle(
                            color = Color(0xFFDBDBDB),
                            fontWeight = FontWeight.W400,
                            fontSize = 13.sp
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun VoteInfoColumnPreview() {
    VoteInfoColumn()
}