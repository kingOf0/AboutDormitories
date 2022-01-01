package com.kingOf0.aboutdormitories.dataaccess

import com.kingOf0.aboutdormitories.entity.Dormitory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DormitoryDao : JpaRepository<Dormitory, Int> {



}