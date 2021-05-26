package com.ds.ciceksepeti.common.usecase

import com.ds.ciceksepeti.common.repository.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowDataStateUseCase<in Params, Result> {

    protected abstract fun execute(params: Params): Flow<DataState<Result>>

    operator fun invoke(params: Params): Flow<DataState<Result>> = execute(params)
        .flowOn(Dispatchers.IO)

}