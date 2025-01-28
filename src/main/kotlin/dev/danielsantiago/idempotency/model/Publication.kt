package dev.danielsantiago.idempotency.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Publication(
    @Id
    @GeneratedValue(strategy= AUTO)
    var id: Long? = null,
    var title: String,
    var content: String,
    val creationDate: LocalDateTime = LocalDateTime.now()
)
