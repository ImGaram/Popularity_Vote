package com.assignment.popularityvote.feature.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.popularityvote.ui.theme.Primary

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pagerSize: Int,
) {
    Row(modifier = modifier) {
        repeat(pagerSize) {
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

@Preview
@Composable
fun PagerIndicatorPreview() {
    PagerIndicator(
        modifier = Modifier.padding(bottom = 12.dp),
        pagerState = rememberPagerState { 3 },
        pagerSize = 3
    )
}