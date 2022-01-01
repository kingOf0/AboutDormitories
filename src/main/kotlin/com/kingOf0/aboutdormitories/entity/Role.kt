package com.kingOf0.aboutdormitories.entity

import com.kingOf0.aboutdormitories.model.ERole
import javax.persistence.*

@Entity
@Table(name = "roles")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    val name: ERole? = null
}