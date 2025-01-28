package dev.danielsantiago.idempotency.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class ClockController {

    @GetMapping("/time")
    fun currentTime(): String {
        return LocalDateTime.now().toString()
    }

}