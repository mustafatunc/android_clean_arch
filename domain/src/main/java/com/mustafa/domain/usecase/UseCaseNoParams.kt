package com.mustafa.domain.usecase

import com.mustafa.domain.exception.BaseException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class UseCaseNoParams<out ReturnType> where ReturnType : Any {

    @Throws(BaseException::class)
    abstract suspend fun run(): ReturnType

    open operator fun invoke(
        scope: CoroutineScope,
        onSuccess: (ReturnType) -> Unit = {},
        onFailure: (BaseException) -> Unit = {}
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                onSuccess(run())
            } catch (ex: BaseException) {
                onFailure(ex)
            }
        }
    }
}