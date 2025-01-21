package com.assignment.popularityvote.core.data.response

import com.google.gson.annotations.SerializedName

data class CandidateListResponse(
    @SerializedName("content") val content: List<Content>
)