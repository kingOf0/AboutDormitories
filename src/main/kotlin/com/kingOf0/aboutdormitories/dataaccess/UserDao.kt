package com.kingOf0.aboutdormitories.dataaccess

import com.kingOf0.aboutdormitories.entity.User
import com.kingOf0.askit.core.utilities.results.DataResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : CrudRepository<User, Int> {
    fun findByUsername(username: String) : User
    fun existsByUsername(username: String) : Boolean
    fun existsByEmail(email: String) : Boolean
}