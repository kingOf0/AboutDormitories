package com.kingOf0.askit.core.utilities.results

class ErrorDataResult<T>(data: T, message: String? = null) : DataResult<T>(true, message, data)