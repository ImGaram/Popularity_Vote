package com.assignment.popularityvote.feature.main

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.popularityvote.common.Resources
import com.assignment.popularityvote.core.data.request.VoteRequest
import com.assignment.popularityvote.core.data.response.CandidateListResponse
import com.assignment.popularityvote.core.repository.VoteRepository
import com.assignment.popularityvote.feature.state.ResponseState
import com.assignment.popularityvote.feature.util.UserId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val voteRepository: VoteRepository
): ViewModel() {

    // todo :: 2025년 2월 3일 0시까지의 카운트다운
    //  후보자 목록 불러오기
    //  사용자가 투표한 후보자 목록 불러오기
    private val _countdown = MutableStateFlow<List<String>?>(null)
    val countdown = _countdown.asStateFlow()

    private val _candidates = MutableStateFlow(ResponseState<CandidateListResponse>())
    val candidates = _candidates.asStateFlow()

    private val _votedList = MutableStateFlow(ResponseState<List<Int>>())
    val votedList = _votedList.asStateFlow()

    private val _voted = MutableStateFlow(ResponseState<Unit>())
    val voted = _voted.asStateFlow()

    fun setCountdown() {
        val current = System.currentTimeMillis()
        val goalDateMillis = LocalDateTime.of(2025, 2, 3, 0, 0)
            .atZone(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli()

        if (goalDateMillis - current > 0) {
            val timer = object : CountDownTimer(goalDateMillis - current, 1000) {
                override fun onTick(p0: Long) {
                    _countdown.update { millisToString(p0).split(" ") }
                }

                override fun onFinish() {

                }
            }

            timer.start()
        }
    }

    fun getAllCandidates() {
        viewModelScope.launch {
            voteRepository.getAllCandidates(sort = listOf("name,ASC")).collect { res ->
                when (res) {
                    is Resources.Loading -> {
                        _candidates.update {
                            it.copy(isLoading = res.isLoading)
                        }
                    }
                    is Resources.Success -> {
                        _candidates.update {
                            it.copy(
                                response = res.data
                            )
                        }
                    }
                    is Resources.Error -> {
                        _candidates.update {
                            it.copy(
                                isLoading = false,
                                response = null
                            )
                        }
                    }
                }
            }
        }
    }

    fun getVotedCandidates() {
        viewModelScope.launch {
            voteRepository.getVotedCandidates(UserId.getInstance()!!).collect { res ->
                when (res) {
                    is Resources.Loading -> {
                        _votedList.update {
                            it.copy(isLoading = res.isLoading)
                        }
                    }
                    is Resources.Success -> {
                        _votedList.update {
                            it.copy(response = res.data)
                        }
                    }
                    is Resources.Error -> {
                        _votedList.update {
                            it.copy(
                                isLoading = false,
                                response = null
                            )
                        }
                    }
                }
            }
        }
    }

    fun vote(candidateId: Int) {
        viewModelScope.launch {
            voteRepository.vote(
                requestBody = VoteRequest(
                    id = candidateId,
                    userId = UserId.getInstance()!!,
                )
            ).collect { res ->
                when (res) {
                    is Resources.Loading -> {
                        _voted.update {
                            it.copy(isLoading = res.isLoading)
                        }
                    }
                    is Resources.Success -> {
                        _voted.update {
                            it.copy(response = res.data)
                        }
                        getAllCandidates()
                        getVotedCandidates()
                    }
                    is Resources.Error -> {
                        _voted.update {
                            it.copy(
                                isLoading = false,
                                response = null
                            )
                        }
                    }
                }
            }
        }
    }

    private fun millisToString(millis: Long): String {
        val seconds = millis / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24

        return "$days ${hours % 24} ${minutes % 60} ${seconds % 60}"
    }
}