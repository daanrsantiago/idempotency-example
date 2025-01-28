package dev.danielsantiago.idempotency.configuration

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate


@Bean
fun redisTemplate(connectionFactory: RedisConnectionFactory?): RedisTemplate<*, *> {
    val template: RedisTemplate<*, *> = RedisTemplate<Any, Any>()
    template.connectionFactory = connectionFactory

    return template
}