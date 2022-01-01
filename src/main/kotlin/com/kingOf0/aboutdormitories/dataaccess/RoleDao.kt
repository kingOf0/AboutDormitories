package com.kingOf0.aboutdormitories.dataaccess

import com.kingOf0.aboutdormitories.entity.Role
import com.kingOf0.aboutdormitories.entity.User
import com.kingOf0.aboutdormitories.model.ERole
import com.kingOf0.askit.core.utilities.results.DataResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleDao : CrudRepository<Role, Int> {
    fun findByName(name: ERole) : Role
}