package com.assignment.popularityvote.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.popularityvote.common.Resources
import com.assignment.popularityvote.core.data.request.VoteRequest
import com.assignment.popularityvote.core.data.response.CandidateResponse
import com.assignment.popularityvote.core.repository.VoteRepository
import com.assignment.popularityvote.feature.state.ResponseState
import com.assignment.popularityvote.feature.util.UserId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val voteRepository: VoteRepository
): ViewModel() {

    private val _candidate = MutableStateFlow(ResponseState<CandidateResponse>())
    val candidate = _candidate.asStateFlow()

    fun getCandidateInfo(candidateId: Int) {
        viewModelScope.launch {
            voteRepository.getCandidateInfo(
                id = candidateId,
                userId = UserId.getInstance().toString()
            ).collect { res ->
                when (res) {
                    is Resources.Loading -> {
                        _candidate.update {
                            it.copy(isLoading = res.isLoading)
                        }
                    }
                    is Resources.Success -> {
                        _candidate.update {
                            it.copy(response = res.data)
                        }
                    }
                    is Resources.Error -> {
                        _candidate.update {
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
                if (res is Resources.Success) {
                    getCandidateInfo(candidateId)
                }
            }
        }
    }
}