package dev.danielsantiago.idempotency.controller

import dev.danielsantiago.idempotency.controller.request.PublicationRequest
import dev.danielsantiago.idempotency.model.Publication
import dev.danielsantiago.idempotency.repository.PublicationRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/publication")
class PublicationController(
    val publicationRepository: PublicationRepository,
    val template: RedisTemplate<String, String>
) {
    val PREFIX = "publication:idempotency:"

    @GetMapping()
    fun getPublications(): List<Publication> {
        return publicationRepository.findAll().toList()
    }

    @PostMapping()
    fun publishPublication(@RequestBody body: PublicationRequest): ResponseEntity<Publication> {
        val publishedPublication = publicationRepository.save(
            Publication(
                title = body.title,
                content = body.content
            )
        )
        return ResponseEntity.status(CREATED).body(publishedPublication)
    }

    @PostMapping("/idempotent")
    fun eventualIdempotency(@RequestBody body: PublicationRequest): ResponseEntity<Publication> {
        if(template.opsForValue().setIfAbsent(PREFIX + body.hashCode(), "1")!!) {
            val publishedPublication = publicationRepository.save(
                Publication(
                    title = body.title,
                    content = body.content
                )
            )
            return ResponseEntity.status(CREATED).body(publishedPublication)
        } else {
            return ResponseEntity.status(UNPROCESSABLE_ENTITY).build()
        }
    }

    @PutMapping("/{id}")
    fun alterPublication(@PathVariable id: Long, @RequestBody body: PublicationRequest): ResponseEntity<Publication> {
        val publicationOptional = publicationRepository.findById(id)
        if (publicationOptional.isPresent) {
            val publication = publicationOptional.get()
            publication.title = body.title
            publication.content = body.content
            return ResponseEntity.ok(publication)
        } else {
            return ResponseEntity(NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deletePublication(@PathVariable id: Long): ResponseEntity<Any> {
        if (publicationRepository.existsById(id)) {
            publicationRepository.deleteById(id)
            return ResponseEntity.ok(null)
        } else {
            return ResponseEntity.notFound().build()
        }
    }

}