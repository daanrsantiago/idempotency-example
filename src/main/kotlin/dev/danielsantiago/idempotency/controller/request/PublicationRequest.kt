package dev.danielsantiago.idempotency.controller.request

data class PublicationRequest (
    val title: String,
    val content: String
)