package dev.danielsantiago.idempotency.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CounterController {

    var counter = 0

    @GetMapping("/counter/increase")
    fun increaseCounter(): Int {
        return ++counter
    }

    @GetMapping("/counter/decrease")
    fun decreaseCounter(): Int {
        return --counter
    }

}