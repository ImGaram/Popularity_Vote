package com.assignment.popularityvote.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignment.popularityvote.R
import com.assignment.popularityvote.common.compose.PopularityVoteText
import com.assignment.popularityvote.common.compose.TopBar
import com.assignment.popularityvote.feature.main.component.CandidateLazyVerticalGrid
import com.assignment.popularityvote.feature.main.component.TimeBox
import com.assignment.popularityvote.feature.main.component.VoteInfoColumn
import com.assignment.popularityvote.ui.theme.Background
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    navigateToLogin: () -> Unit,
    navigateToProfile: () -> Unit,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val candidates by mainViewModel.candidates.collectAsState()
    val votedList by mainViewModel.votedList.collectAsState()
    val countdown by mainViewModel.countdown.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.setCountdown()
        mainViewModel.getAllCandidates()
        mainViewModel.getVotedCandidates()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        topBar = {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                backArrowEnable = true,
                onBackArrowClick = navigateToLogin
            )
        }
    ) { paddingValues ->

        LazyColumn (
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
                .background(Background)
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.img_promote_post),
                    contentDescription = "promote post image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    val unit = listOf("DAY", "HR", "MIN", "SEC")

                    for (i in 1 .. 7) {
                        if (i % 2 == 0) {
                            PopularityVoteText(
                                text = ":",
                                modifier = Modifier
                                    .width(18.dp)
                                    .padding(bottom = 12.dp),
                                style = TextStyle(
                                    color = Color(0xFFDADADA),
                                    fontWeight = FontWeight.W500,
                                    fontSize = 23.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        } else {
                            TimeBox(
                                value = countdown?.get(i / 2) ?: "0",
                                unit = unit[i / 2]
                            )
                        }
                    }
                }
            }

            item {
                VoteInfoColumn()
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(20.dp)
                        .height(3.dp)
                        .background(Primary)
                )
            }

            item {
                PopularityVoteText(
                    text = "2024\nCandidate List",
                    modifier = Modifier.padding(start = 16.dp, top = 12.dp),
                    style = TextStyle(
                        color = White,
                        fontWeight = FontWeight.W600,
                        fontSize = 28.sp
                    )
                )
            }

            item {
                PopularityVoteText(
                    text = "※ You can vote for up to 3 candidates",
                    modifier = Modifier.padding(start = 16.dp, top = 24.dp),
                    style = TextStyle(
                        color = Color(0xFFAEAEB2)
                    )
                )
            }

            if (candidates.response != null && votedList.response != null) {
                item {
                    CandidateLazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp)
                            .heightIn(max = 3000.dp)
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp),
                        candidates = candidates.response!!,
                        votedList = votedList.response!!,
                        onProfileItemClick = {
                            navigateToProfile(/*it*/)
                        },
                        onVoteButtonItemClick = {
                            if (votedList.response!!.size < 3) {
                                mainViewModel.vote(it)
                            }
                        }
                    )
                }
            } else {
                item {
                    CircularProgressIndicator(modifier = Modifier.fillMaxWidth(), color = Primary)
                }
            }
        }
    }
}
