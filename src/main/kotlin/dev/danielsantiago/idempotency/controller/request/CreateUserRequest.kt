package dev.danielsantiago.idempotency.controller.request

data class CreateUserRequest (
    val name: String,
    val age: Int,
    val cpf: String
)