package com.assignment.popularityvote.core.api

import com.assignment.popularityvote.core.data.request.VoteRequest
import com.assignment.popularityvote.core.data.response.CandidateListResponse
import com.assignment.popularityvote.core.data.response.CandidateResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface VoteApi {

    @POST("vote")
    suspend fun vote(@Body requestBody: VoteRequest): Unit?

    @GET("vote/candidate/{id}")
    suspend fun getCandidateInfo(
        @Path("id") id: Int,
        @Query("userId") userId: String,
    ): CandidateResponse?

    @GET("vote/candidate/list")
    suspend fun getAllCandidates(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 100,
        @Query("sort") sort: List<String>
    ): CandidateListResponse?

    @GET("vote/voted/candidate/list")
    suspend fun getVotedCandidates(
        @Query("userId") userId: String
    ): List<Int>?
}