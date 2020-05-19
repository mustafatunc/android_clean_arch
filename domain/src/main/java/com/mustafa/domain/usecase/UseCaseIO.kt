package com.mustafa.domain.usecase

import com.mustafa.domain.exception.BaseException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class UseCaseIO<out ReturnType, in Params> where ReturnType : Any {

    @Throws(BaseException::class)
    abstract suspend fun run(
        params: Params
    ): ReturnType

    open operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (ReturnType) -> Unit = {},
        onFailure: (BaseException) -> Unit = {}
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                onSuccess(run(params))
            } catch (ex: BaseException) {
                onFailure(ex)
            }
        }
    }

}
