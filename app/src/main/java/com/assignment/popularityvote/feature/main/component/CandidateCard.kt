package com.assignment.popularityvote.feature.main.component

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.assignment.popularityvote.common.compose.PopularityVoteButton
import com.assignment.popularityvote.common.compose.PopularityVoteText
import com.assignment.popularityvote.core.data.response.Content
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White

@Composable
fun CandidateCard(
    modifier: Modifier = Modifier,
    data: Content,
    isVoted: Boolean = false,
    onProfileClick: (Int) -> Unit,
    onVoteButtonClick: (Int) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = data.profileUrl,
            contentDescription = "candidate profile url",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFDBDBDB))
                .clickable {
                    onProfileClick(data.id)
                },
            contentScale = ContentScale.FillWidth
        )

        PopularityVoteText(
            text = data.name,
            modifier = Modifier.padding(top = 18.dp),
            style = TextStyle(
                color = White,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
            )
        )

        val decimalFormat = DecimalFormat("#,###")
        PopularityVoteText(
            text = "${decimalFormat.format(data.voteCnt.toInt())} voted",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
            )
        )

        PopularityVoteButton(
            onClick = {
                onVoteButtonClick(data.id)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isVoted) White else Primary
            ),
            text = if (isVoted) "Voted" else "Vote",
            textStyle = TextStyle(
                color = if (isVoted) Primary else White,
                fontWeight = FontWeight.W700,
                fontSize = 16.sp
            )
        )
    }
}

@Preview
@Composable
private fun CandidateCardPreview() {
    Row {
        CandidateCard(
            modifier = Modifier.weight(1f),
            data = Content(
                id = 1,
                candidateNumber = 1,
                name = "test",
                profileUrl = "https://angkorchat-bucket.s3.ap-southeast-1.amazonaws.com/candidate/59/2ecfcd892e574f2b91d8df745deee9ed.png",
                voteCnt = "1200"
            ),
            onProfileClick = {},
            onVoteButtonClick = {}
        )

        CandidateCard(
            modifier = Modifier.weight(1f),
            data = Content(
                id = 1,
                candidateNumber = 1,
                name = "test",
                profileUrl = "https://angkorchat-bucket.s3.ap-southeast-1.amazonaws.com/candidate/59/2ecfcd892e574f2b91d8df745deee9ed.png",
                voteCnt = "1200"
            ),
            isVoted = true,
            onProfileClick = {},
            onVoteButtonClick = {}
        )
    }
}