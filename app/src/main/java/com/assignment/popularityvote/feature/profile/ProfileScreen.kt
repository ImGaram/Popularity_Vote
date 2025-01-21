package com.assignment.popularityvote.feature.profile

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignment.popularityvote.R
import com.assignment.popularityvote.common.compose.PopularityVoteButton
import com.assignment.popularityvote.common.compose.PopularityVoteText
import com.assignment.popularityvote.common.compose.TopBar
import com.assignment.popularityvote.common.navigation.Screen
import com.assignment.popularityvote.feature.profile.component.CandidateInfoColumn
import com.assignment.popularityvote.feature.profile.component.PagerIndicator
import com.assignment.popularityvote.feature.profile.component.ProfileImageHorizontalPager
import com.assignment.popularityvote.ui.theme.Background
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ProfileScreen(
    navigateToMain: () -> Unit,
    args: Screen.ProfileScreen,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val candidate by profileViewModel.candidate.collectAsState()

    LaunchedEffect(Unit) {
        profileViewModel.getCandidateInfo(args.id)
    }

    if (candidate.response != null) {
        val pagerState = rememberPagerState { candidate.response!!.profileInfoList.size }

        LaunchedEffect(key1 = pagerState.currentPage) {
            launch {
                delay(3000)

                withContext(NonCancellable) {
                    val next = if (pagerState.currentPage < candidate.response!!.profileInfoList.size - 1)
                        pagerState.currentPage + 1
                    else
                        0

                    pagerState.animateScrollToPage(
                        page = next,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            }
        }

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            topBar = {
                TopBar(
                    modifier = Modifier.fillMaxWidth(),
                    backArrowEnable = true,
                    onBackArrowClick = navigateToMain
                )
            },
            bottomBar = {
                PopularityVoteButton(
                    onClick = {
                        if (!candidate.response!!.voted) {
                            profileViewModel.vote(args.id)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background)
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (candidate.response!!.voted) White else Primary
                    ),
                    border = if (candidate.response!!.voted) BorderStroke(width = 1.dp, color = Primary) else null,
                    text = if (candidate.response!!.voted) "Voted" else "Vote",
                    textStyle = TextStyle(
                        color = if (candidate.response!!.voted) Primary else White,
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp
                    ),
                    buttonIcon = {
                        if (candidate.response!!.voted) {
                            Icon(
                                painter = painterResource(R.drawable.ic_voted),
                                contentDescription = "voted complete icon",
                                tint = Primary
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .fillMaxSize()
                    .background(Background)
            ) {

                item {
                    val profileInfoList = candidate.response!!.profileInfoList

                    Box(contentAlignment = Alignment.BottomCenter) {
                        ProfileImageHorizontalPager(
                            pagerState = pagerState,
                            images = profileInfoList,
                        )

                        PagerIndicator(
                            modifier = Modifier.padding(bottom = 12.dp),
                            pagerState = pagerState,
                            pagerSize = profileInfoList.size
                        )
                    }
                }

                item {
                    CandidateInfoColumn(
                        candidate = candidate.response!!
                    )
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        PopularityVoteText(
                            text = "COPYRIGHT © WUPSC ALL RIGHT RESERVED.",
                            style = TextStyle(
                                color = Color(0xFFF8F8FC),
                                fontWeight = FontWeight.W300,
                                fontSize = 10.sp
                            )
                        )
                    }
                }
            }
        }
    }
}
