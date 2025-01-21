package com.assignment.popularityvote.di

import com.assignment.popularityvote.core.api.VoteApi
import com.assignment.popularityvote.core.repository.VoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVoteRepository(voteApi: VoteApi): VoteRepository {
        return VoteRepository(voteApi)
    }
}