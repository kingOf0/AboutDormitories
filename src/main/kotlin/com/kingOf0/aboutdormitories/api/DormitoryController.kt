package com.kingOf0.aboutdormitories.api

import com.kingOf0.aboutdormitories.business.DormitoryService
import com.kingOf0.aboutdormitories.entity.Dormitory
import com.kingOf0.askit.core.utilities.results.DataResult
import com.kingOf0.askit.core.utilities.results.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/dormitories")
class DormitoryController @Autowired constructor(
    private val dormitoryManager: DormitoryService
)  {

    @GetMapping("getAllDormitories")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR')")
    fun getAllDormitories() : DataResult<List<Dormitory>> {
        return dormitoryManager.getAllDormitories()
    }

    @PostMapping("addDormitory")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    fun addDormitory(@RequestBody dormitory: Dormitory) : Result {
        return dormitoryManager.addDormitory(dormitory)
    }

    @PatchMapping("patchDormitory")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    fun patchDormitory(@RequestBody dormitory: Dormitory) : Result {
        return dormitoryManager.patchDormitory(dormitory)
    }

}