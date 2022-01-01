package com.kingOf0.askit.core.utilities.results

class SuccessDataResult<T>(data: T, message: String? = null) : DataResult<T>(true, message, data)