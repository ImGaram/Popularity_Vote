package com.assignment.popularityvote.feature.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.assignment.popularityvote.core.data.response.ProfileInfo
import com.assignment.popularityvote.ui.theme.Primary

@Composable
fun ProfileImageHorizontalPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    images: List<ProfileInfo>
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        Box(contentAlignment = Alignment.BottomCenter) {
            SubcomposeAsyncImage(
                model = images[page].profileUrl,
                contentDescription = "candidate profile url $page",
                loading = {
                    CircularProgressIndicator(color = Primary)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview
@Composable
fun ProfileImageHorizontalPagerPreview() {
    val pagerState = rememberPagerState { 3 }

    Box(contentAlignment = Alignment.BottomCenter) {
        ProfileImageHorizontalPager(
            pagerState = pagerState,
            images = listOf(
                ProfileInfo(
                    fileArea = 1,
                    displayOrder = 0,
                    profileUrl = "https://angkorchat-bucket.s3.ap-southeast-1.amazonaws.com/candidate/59/2ecfcd892e574f2b91d8df745deee9ed.png",
                    mimeType = "image/png"
                ),
                ProfileInfo(
                    fileArea = 2,
                    displayOrder = 0,
                    profileUrl = "https://angkorchat-bucket.s3.ap-southeast-1.amazonaws.com/candidate/59/85d28eca90524815bbab073cb007a8f1.png",
                    mimeType = "image/png"
                ),
                ProfileInfo(
                    fileArea = 3,
                    displayOrder = 0,
                    profileUrl = "https://angkorchat-bucket.s3.ap-southeast-1.amazonaws.com/candidate/59/57f5561585ee4f71b9259bfc6d5d8e5e.png",
                    mimeType = "image/png"
                ),
            )
        )

        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            repeat(3) {
                val indicatorColor = if (pagerState.currentPage == it) Primary else Color(0xFFE2D4CE)

                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(CircleShape)
                        .background(indicatorColor)
                        .size(8.dp)
                )
            }
        }
    }
}