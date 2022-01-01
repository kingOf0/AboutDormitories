package com.kingOf0.aboutdormitories.api

import com.kingOf0.aboutdormitories.dataaccess.RoleDao
import com.kingOf0.aboutdormitories.dataaccess.UserDao
import com.kingOf0.aboutdormitories.entity.Role
import com.kingOf0.aboutdormitories.entity.User
import com.kingOf0.aboutdormitories.model.ERole
import com.kingOf0.aboutdormitories.payload.request.LoginRequest
import com.kingOf0.aboutdormitories.payload.request.SignupRequest
import com.kingOf0.aboutdormitories.payload.response.JwtResponse
import com.kingOf0.aboutdormitories.security.jwt.JwtUtils
import com.kingOf0.aboutdormitories.security.service.UserDetailsImpl
import com.kingOf0.askit.core.utilities.results.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.function.Consumer
import java.util.stream.Collectors

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
class AuthController {

    @Autowired
    var authenticationManager: AuthenticationManager? = null

    @Autowired
    var userRepository: UserDao? = null

    @Autowired
    var roleRepository: RoleDao? = null

    @Autowired
    var encoder: PasswordEncoder? = null

    @Autowired
    var jwtUtils: JwtUtils? = null
    @PostMapping("/signin")
    fun authenticateUser(@RequestBody loginRequest: LoginRequest): Result {
        val authentication: Authentication = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils!!.generateJwtToken(authentication)
        val userDetails = authentication.principal as UserDetailsImpl
        val roles = userDetails.authorities.stream()
            .map { item: GrantedAuthority -> item.authority }
            .collect(Collectors.toList())

        return SuccessDataResult(JwtResponse(jwt, userDetails.id, userDetails.username, userDetails.email, roles),"Success signin user")
    }

    @PostMapping("/signup")
    fun registerUser(@RequestBody signUpRequest: SignupRequest): Result {
        if (userRepository?.existsByUsername(signUpRequest.username) == true)
            return ErrorResult("Error: Username is already taken!")
        if (userRepository?.existsByEmail(signUpRequest.email) == true)
            return ErrorResult("Error: E Mail is already taken!")

        // Create new user's account
        val user = User(
            null,
            signUpRequest.username,
            encoder!!.encode(signUpRequest.password),
            signUpRequest.email
        )

        roleRepository?.findByName(ERole.ROLE_USER)?.let {
            user.roles.add(it)
        }

        userRepository?.save(user)
        return SuccessResult("User registered successfully!")
    }
}
