package dev.danielsantiago.idempotency.repository

import dev.danielsantiago.idempotency.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
}