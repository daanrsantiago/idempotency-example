package dev.danielsantiago.idempotency.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = AUTO)
    var id: Long? = null,
    val name: String,
    val age: Int,
    @Column(unique = true)
    val cpf: String
)
