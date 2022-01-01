package com.kingOf0.aboutdormitories.security.service

import com.kingOf0.aboutdormitories.dataaccess.UserDao
import com.kingOf0.aboutdormitories.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserDao

    @Transactional
    override fun loadUserByUsername(username: String?): UserDetails? {
        return username?.let {
            val user: User = userRepository.findByUsername(username)
            return buildUserDetails(user)
        }
    }
}