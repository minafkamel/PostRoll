package com.minafkamel.postroll.domain.base

import kotlinx.coroutines.flow.Flow

interface UseCase<Params, Result> {

    suspend operator fun invoke(params : Params): Flow<Result>
}
