package com.assignment.popularityvote.core.data.response

import com.google.gson.annotations.SerializedName

data class CandidateResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("candidateNumber") val candidateNumber: Int,
    @SerializedName("name") val name: String,
    @SerializedName("education") val education: String,
    @SerializedName("major") val major: String,
    @SerializedName("hobby") val hobby: String,
    @SerializedName("talent") val talent: String,
    @SerializedName("ambition") val ambition: String,
    @SerializedName("contents") val contents: String,
    @SerializedName("profileInfoList") val profileInfoList: List<ProfileInfo>,
    @SerializedName("voted") val voted: Boolean
)