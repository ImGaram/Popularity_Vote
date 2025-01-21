package com.assignment.popularityvote.feature.profile.component

import androidx.compose.foundation.layout.Column
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
import com.assignment.popularityvote.core.data.response.CandidateResponse
import com.assignment.popularityvote.ui.theme.BackgroundLight
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White

@Composable
fun CandidateInfoColumn(candidate: CandidateResponse, ) {
    Column(modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)) {

        PopularityVoteText(
            text = candidate.name,
            modifier = Modifier.padding(top = 24.dp),
            style = TextStyle(
                color = White,
                fontWeight = FontWeight.W500,
                fontSize = 22.sp
            )
        )

        PopularityVoteText(
            text = "Entry No.${candidate.candidateNumber}",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp),
            colors = CardDefaults.cardColors(containerColor = BackgroundLight),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                PopularityVoteText(
                    text = "Education",
                    style = TextStyle(
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )

                PopularityVoteText(
                    text = candidate.education,
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0xFF282627)
                )

                PopularityVoteText(
                    text = "Major",
                    style = TextStyle(
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )

                PopularityVoteText(
                    text = candidate.major,
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0xFF282627)
                )

                PopularityVoteText(
                    text = "Hobbies",
                    style = TextStyle(
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )

                PopularityVoteText(
                    text = candidate.hobby,
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0xFF282627)
                )

                PopularityVoteText(
                    text = "Talent",
                    style = TextStyle(
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )

                PopularityVoteText(
                    text = candidate.talent,
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0xFF282627)
                )

                PopularityVoteText(
                    text = "Ambition",
                    style = TextStyle(
                        color = Color(0xFF7C7C7C),
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )

                PopularityVoteText(
                    text = candidate.ambition,
                    modifier = Modifier.padding(top = 10.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun CandidateInfoColumnPreview() {
    CandidateInfoColumn(
        candidate = CandidateResponse(
            id = 1,
            candidateNumber = 9,
            name = "test",
            education = "Bashkir State Agrarian University",
            major = "Business ans Marketing",
            hobby = "Reading books",
            talent = "Singing",
            ambition = "test ambition",
            contents = "vote me",
            profileInfoList = emptyList(),
            voted = true
        )
    )
}