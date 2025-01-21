package com.assignment.popularityvote.feature.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.assignment.popularityvote.core.data.response.CandidateListResponse

@Composable
fun CandidateLazyVerticalGrid(
    modifier: Modifier = Modifier,
    candidates: CandidateListResponse,
    votedList: List<Int>,
    onProfileItemClick: (Int) -> Unit,
    onVoteButtonItemClick: (Int) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = false
    ) {
        items(candidates.content) {
            CandidateCard(
                data = it,
                isVoted = votedList.contains(it.id),
                onProfileClick = onProfileItemClick,
                onVoteButtonClick = onVoteButtonItemClick
            )
        }
    }
}
