package com.domain.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<out O, in I> {


  operator fun invoke(): Flow<Result<O>> = throw NotImplementedError()

  operator fun invoke(params: I): Flow<Result<O>> = throw NotImplementedError()

  suspend fun perform(): O = throw NotImplementedError()

  suspend fun perform(params: I): O? = throw NotImplementedError()
}
