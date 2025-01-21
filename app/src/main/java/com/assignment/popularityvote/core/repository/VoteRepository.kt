package com.assignment.popularityvote.core.repository

import com.assignment.popularityvote.common.Resources
import com.assignment.popularityvote.core.api.VoteApi
import com.assignment.popularityvote.core.data.request.VoteRequest
import com.assignment.popularityvote.core.data.response.CandidateListResponse
import com.assignment.popularityvote.core.data.response.CandidateResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VoteRepository @Inject constructor(
    private val voteApi: VoteApi
) {

    suspend fun vote(requestBody: VoteRequest): Flow<Resources<Unit?>> {
        return flow {
            emit(Resources.Loading(false))

            val response = try {
                voteApi.vote(requestBody)
            } catch (e: Exception) {
                emit(Resources.Error())
                emit(Resources.Loading(false))
                return@flow
            }

            response?.let {
                emit(Resources.Success(it))
                emit(Resources.Loading(false))
                return@flow
            }

            emit(Resources.Error())
            emit(Resources.Loading(false))
        }
    }

    suspend fun getCandidateInfo(
        id: Int,
        userId: String,
    ): Flow<Resources<CandidateResponse?>> {
        return flow {
            emit(Resources.Loading(true))

            val response = try {
                voteApi.getCandidateInfo(id, userId)
            } catch (e: Exception) {
                emit(Resources.Error())
                emit(Resources.Loading(false))
                return@flow
            }

            response?.let {
                emit(Resources.Success(it))
                emit(Resources.Loading(false))
                return@flow
            }

            emit(Resources.Error())
            emit(Resources.Loading(false))
        }
    }

    suspend fun getAllCandidates(sort: List<String>): Flow<Resources<CandidateListResponse?>> {
        return flow {
            emit(Resources.Loading(true))

            val response = try {
                voteApi.getAllCandidates(sort = sort)
            } catch (e: Exception) {
                emit(Resources.Error())
                emit(Resources.Loading(false))
                return@flow
            }

            response?.let {
                emit(Resources.Success(it))
                emit(Resources.Loading(false))
                return@flow
            }

            emit(Resources.Error())
            emit(Resources.Loading(false))
        }
    }

    suspend fun getVotedCandidates(userId: String): Flow<Resources<List<Int>?>> {
        return flow {
            emit(Resources.Loading(true))

            val response = try {
                voteApi.getVotedCandidates(userId)
            } catch (e: Exception) {
                emit(Resources.Error())
                emit(Resources.Loading(false))
                return@flow
            }

            response?.let {
                emit(Resources.Success(it))
                emit(Resources.Loading(false))
                return@flow
            }

            emit(Resources.Error())
            emit(Resources.Loading(false))
        }
    }
}