package dev.danielsantiago.idempotency.controller

import dev.danielsantiago.idempotency.controller.request.CreateUserRequest
import dev.danielsantiago.idempotency.model.User
import dev.danielsantiago.idempotency.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    val userRepository: UserRepository
){

    @GetMapping
    fun getUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    @PostMapping
    fun createUser(@RequestBody user: CreateUserRequest): ResponseEntity<User?> {
        try {
            val createdUser = userRepository.save(
                User(
                    name = user.name,
                    age = user.age,
                    cpf = user.cpf
                )
            )
            return ResponseEntity.status(CREATED).body(createdUser)
        } catch (e: Exception) {
            return ResponseEntity.status(UNPROCESSABLE_ENTITY).build()
        }
    }

}