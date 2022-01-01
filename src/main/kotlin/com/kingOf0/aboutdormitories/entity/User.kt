package com.kingOf0.aboutdormitories.entity

import com.kingOf0.aboutdormitories.model.ERole
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String,
    val password: String,
    val email: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Role> = HashSet(),

)