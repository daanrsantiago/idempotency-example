package dev.danielsantiago.idempotency.repository

import dev.danielsantiago.idempotency.model.Publication
import org.springframework.data.repository.CrudRepository

interface PublicationRepository: CrudRepository<Publication, Long> {
}