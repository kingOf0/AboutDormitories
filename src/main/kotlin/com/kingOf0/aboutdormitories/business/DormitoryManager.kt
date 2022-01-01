package com.kingOf0.aboutdormitories.business

import com.kingOf0.aboutdormitories.core.utilities.copyFields
import com.kingOf0.aboutdormitories.dataaccess.DormitoryDao
import com.kingOf0.aboutdormitories.entity.Dormitory
import com.kingOf0.askit.core.utilities.results.DataResult
import com.kingOf0.askit.core.utilities.results.Result
import com.kingOf0.askit.core.utilities.results.SuccessDataResult
import com.kingOf0.askit.core.utilities.results.SuccessResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DormitoryManager @Autowired constructor(
    private val dormitoryDAO: DormitoryDao
) : DormitoryService {

    override fun getAllDormitories(): DataResult<List<Dormitory>> {
        return SuccessDataResult(dormitoryDAO.findAll())
    }

    override fun addDormitory(dormitory: Dormitory): Result {
        dormitoryDAO.save(dormitory)
        return SuccessResult()
    }

    override fun patchDormitory(dormitory: Dormitory): Result {
        dormitoryDAO.findById(dormitory.id).ifPresent {
            copyFields(dormitory, it)
            dormitoryDAO.save(it)
        }
        return SuccessResult()
    }


}