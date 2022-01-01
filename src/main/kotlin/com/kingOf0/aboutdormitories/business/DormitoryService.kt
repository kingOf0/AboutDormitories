package com.kingOf0.aboutdormitories.business

import com.kingOf0.aboutdormitories.entity.Dormitory
import com.kingOf0.askit.core.utilities.results.DataResult
import com.kingOf0.askit.core.utilities.results.Result

interface DormitoryService {
    fun getAllDormitories(): DataResult<List<Dormitory>>
    fun addDormitory(dormitory: Dormitory): Result
    fun patchDormitory(dormitory: Dormitory): Result
}