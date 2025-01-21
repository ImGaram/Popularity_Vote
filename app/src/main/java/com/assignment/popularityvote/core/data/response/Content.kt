package com.assignment.popularityvote.core.data.response

data class Content(
    val candidateNumber: Int,
    val id: Int,
    val name: String,
    val profileUrl: String,
    val voteCnt: String
)